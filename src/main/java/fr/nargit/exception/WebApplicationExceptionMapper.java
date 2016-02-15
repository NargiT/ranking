package fr.nargit.exception;

import fr.nargit.config.application.Application;
import fr.nargit.rest.resource.response.ErrorMessage;

import javax.ws.rs.WebApplicationException;
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
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

  @Context
  private HttpHeaders headers;

  @Override
  public Response toResponse(WebApplicationException exception) {
    return Response.status(exception.getResponse().getStatus())
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
