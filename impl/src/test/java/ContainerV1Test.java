import fr.nargit.ranking.rest.v1.response.PlayerResponse;
import fr.nargit.ranking.servlet.ApplicationV1ResourceConfig;
import fr.nargit.ranking.spring.CustomSpringContextInitializer;
import org.glassfish.jersey.message.internal.MediaTypes;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.util.runner.ConcurrentRunner;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertThat;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
@RunWith(ConcurrentRunner.class)
public class ContainerV1Test extends JerseyTest {

    @Override
    protected ResourceConfig configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        // configure test context because WebApplicationInitializer is not call from JerseyTest
        final ApplicationV1ResourceConfig resourceConfig = new ApplicationV1ResourceConfig();
        resourceConfig.property("contextConfig", new CustomSpringContextInitializer().configureSpringContext());
        return resourceConfig;
    }

    @Test
    public void testNormalResponse() {
        WebTarget target = target();
        PlayerResponse playerResponse = target
                .path("players/{username}")
                .resolveTemplate("username", "toto")
                .request(MediaType.APPLICATION_JSON)
                .get(PlayerResponse.class);

        assertThat(playerResponse, CoreMatchers.notNullValue());
        assertThat(playerResponse.getPlayerId(), CoreMatchers.nullValue());
        assertThat(playerResponse.getUsername(), CoreMatchers.nullValue());
    }

    /**
     * Test if a WADL document is available at the relative path
     * "application.wadl".
     * <p/>
     */
    @Test
    public void testApplicationWadl() {
        WebTarget target = target();
        String serviceWadl = target.path("application.wadl").request(MediaTypes.WADL_TYPE).get(String.class);

        assertThat(serviceWadl.length(), Matchers.greaterThan(1));
    }

    @Test
    public void testNormalExceptionBehaviour() {
        enable(TestProperties.LOG_TRAFFIC);
        // create a request with invalid json string to cause an exception in Jackson
        Response response = target().path("ranking-service/404")
                .request(MediaType.APPLICATION_JSON)
                .get();

        assertThat(Response.Status.NOT_FOUND.getStatusCode(), CoreMatchers.is(response.getStatus()));
    }

}
