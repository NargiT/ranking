package fr.nargit.exception.v1;

import fr.nargit.config.application.v1.Application;
import fr.nargit.rest.resource.v1.response.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

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
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(new ErrorMessage(exception))
        .type(getMediaType())
        .build();
  }

  private MediaType getMediaType() {

    List<MediaType> supportedMediaTypes = Application.SUPPORTED_MEDIA_TYPES;

    return headers.getAcceptableMediaTypes()
        .stream()
        .filter(supportedMediaTypes::contains)
        .findFirst()
        .orElseGet(() -> MediaType.APPLICATION_JSON_TYPE);
  }
}
