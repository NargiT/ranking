package fr.nargit.ranking.utils;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by NargiT on 17/02/2016
 */
public class WebServiceUtilsTest {

  @Test
  public void testGetSupportedXML() throws Exception {
    HashMap<String, String> parameters1 = new HashMap<>();
    parameters1.put("q", "9");

    HashMap<String, String> parameters2 = new HashMap<>();
    parameters2.put("q", "8");

    Optional<MediaType> mediaType = WebServiceUtils.supportOf(Arrays.asList(
        MediaType.TEXT_HTML_TYPE,
        new MediaType("application", "xml", parameters1),
        new MediaType("*", "*", parameters2)),
        Arrays.asList(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE),
        MediaType.APPLICATION_JSON_TYPE);

    Assert.assertTrue(mediaType.get().isCompatible(MediaType.APPLICATION_XML_TYPE));
  }

  @Test
  public void testGetSupportedJSON() throws Exception {
    Optional<MediaType> mediaType = WebServiceUtils.supportOf(
        Arrays.asList(MediaType.TEXT_HTML_TYPE, MediaType.APPLICATION_JSON_TYPE),
            Arrays.asList(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE),
            MediaType.APPLICATION_JSON_TYPE);

    Assert.assertThat(mediaType.get(), CoreMatchers.is(MediaType.APPLICATION_JSON_TYPE));
  }

  @Test
  public void testGetSupportedDefaultJSON() throws Exception {
    Optional<MediaType> mediaType = WebServiceUtils.supportOf(
        Arrays.asList(MediaType.TEXT_HTML_TYPE, MediaType.TEXT_HTML_TYPE),
        Arrays.asList(MediaType.APPLICATION_JSON_TYPE, MediaType.APPLICATION_XML_TYPE),
        MediaType.APPLICATION_JSON_TYPE);

    Assert.assertThat(mediaType.get(), CoreMatchers.is(MediaType.APPLICATION_JSON_TYPE));
  }
}