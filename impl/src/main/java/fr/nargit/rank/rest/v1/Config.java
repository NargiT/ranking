package fr.nargit.rank.rest.v1;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
public class Config {

  public static final List<MediaType> SUPPORTED_MEDIA_TYPES = Arrays.asList(MediaType.APPLICATION_JSON_TYPE, MediaType
      .APPLICATION_XML_TYPE);

  public static final List<Locale> SUPPORTED_LOCALES = Arrays.asList(Locale.FRANCE, Locale.US);

}
