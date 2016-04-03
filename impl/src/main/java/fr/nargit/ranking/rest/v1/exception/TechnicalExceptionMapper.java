package fr.nargit.ranking.rest.v1.exception;

import fr.nargit.ranking.config.Config;
import fr.nargit.ranking.rest.v1.response.ErrorMessage;
import fr.nargit.ranking.utils.WebServiceUtils;
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
public class TechnicalExceptionMapper implements ExceptionMapper<Throwable> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TechnicalExceptionMapper.class);

  @Context
  private HttpHeaders headers;

  @Override
  public Response toResponse(Throwable exception) {
    LOGGER.error("D'oh !", exception);
    final MediaType mediaType = WebServiceUtils.supportOf(headers.getAcceptableMediaTypes(), Config
            .SUPPORTED_MEDIA_TYPES,
        MediaType.APPLICATION_JSON_TYPE);
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(new ErrorMessage(exception))
        .type(mediaType)
        .build();
  }
}
