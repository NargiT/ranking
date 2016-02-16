package fr.nargit.rank.rest.v1.exception;

import fr.nargit.rank.rest.v1.Config;
import fr.nargit.rank.rest.v1.resource.response.ErrorMessage;
import fr.nargit.rank.utils.WebServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Locale;

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
    LOGGER.warn("The client is a noob : {}", exception.getClass().getCanonicalName());
    return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorMessage(exception))
        .type(WebServiceUtils.supportOf(headers.getAcceptableMediaTypes(), Config.SUPPORTED_MEDIA_TYPES,
            MediaType.APPLICATION_JSON_TYPE))
        .language(WebServiceUtils.supportOf(headers.getAcceptableLanguages(), Config.SUPPORTED_LOCALES, Locale.FRANCE))
        .build();
  }
}
