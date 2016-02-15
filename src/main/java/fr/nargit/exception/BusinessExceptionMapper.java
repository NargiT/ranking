package fr.nargit.exception;

import fr.nargit.config.application.Application;
import fr.nargit.rest.resource.response.ErrorMessage;
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
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {

  private static final Logger LOGGER = LoggerFactory.getLogger(BusinessExceptionMapper.class);

  @Context
  private HttpHeaders headers;

  @Override
  public Response toResponse(BusinessException exception) {
    LOGGER.warn("The client is a noob : {}",exception.getClass().getCanonicalName());
    return Response.status(Response.Status.BAD_REQUEST)
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
