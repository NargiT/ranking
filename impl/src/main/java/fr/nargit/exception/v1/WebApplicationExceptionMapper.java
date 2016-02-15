package fr.nargit.exception.v1;

import fr.nargit.config.application.v1.Application;
import fr.nargit.rest.resource.v1.response.ErrorMessage;

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

    final List<MediaType> acceptableMediaTypes = headers.getAcceptableMediaTypes();
    return acceptableMediaTypes
        .stream()
        // FIXME : check the spec of the q- value
        .filter(supportedMediaTypes::contains)
        .findFirst()
        .orElseGet(() -> MediaType.APPLICATION_JSON_TYPE);
  }
}
