package fr.nargit.ranking.rest.v1.exception;

import fr.nargit.ranking.rest.v1.response.ErrorMessage;
import fr.nargit.ranking.player.exception.RankingException;
import fr.nargit.ranking.rest.v1.exception.utils.WebServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
@Provider
public class ClientExceptionMapper implements ExceptionMapper<RankingException> {

  private static final Logger LOGGER = LoggerFactory.getLogger(ClientExceptionMapper.class);

  @Context
  private HttpHeaders headers;

  @Override
  public Response toResponse(RankingException exception) {
    LOGGER.warn("The client is a noob : {}", exception.getClass().getCanonicalName());

    final MediaType mediaType = WebServiceUtils.supportOf(headers.getAcceptableMediaTypes(), Config
            .SUPPORTED_MEDIA_TYPES,
        MediaType.APPLICATION_JSON_TYPE);

    return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorMessage(exception))
        .type(mediaType)
        .build();
  }
}
