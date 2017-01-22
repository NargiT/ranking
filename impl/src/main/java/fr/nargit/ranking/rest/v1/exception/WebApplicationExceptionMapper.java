package fr.nargit.ranking.rest.v1.exception;

import fr.nargit.ranking.rest.v1.response.ErrorMessage;
import fr.nargit.ranking.rest.v1.exception.utils.WebServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
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
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

  private static final Logger LOGGER = LoggerFactory.getLogger(TechnicalExceptionMapper.class);

  @Context
  private HttpHeaders headers;

  @Override
  public Response toResponse(WebApplicationException exception) {
    LOGGER.error("D'oh !", exception);

    return Response.status(exception.getResponse().getStatus())
        .entity(new ErrorMessage(exception))
        .type(WebServiceUtils.supportOf(headers.getAcceptableMediaTypes(), Config.SUPPORTED_MEDIA_TYPES,
            MediaType.APPLICATION_JSON_TYPE))
        .build();
  }
}
