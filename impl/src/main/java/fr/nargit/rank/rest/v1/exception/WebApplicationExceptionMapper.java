package fr.nargit.rank.rest.v1.exception;

import fr.nargit.rank.rest.v1.Config;
import fr.nargit.rank.rest.v1.resource.response.ErrorMessage;
import fr.nargit.rank.utils.WebServiceUtils;

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

  @Context
  private HttpHeaders headers;

  @Override
  public Response toResponse(WebApplicationException exception) {
    return Response.status(exception.getResponse().getStatus())
        .entity(new ErrorMessage(exception))
        .type(WebServiceUtils.supportOf(headers.getAcceptableMediaTypes(), Config.SUPPORTED_MEDIA_TYPES,
            MediaType.APPLICATION_JSON_TYPE))
        .build();
  }
}
