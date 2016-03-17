package fr.nargit.ranking.rest.v1;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
public class Config {

  public static final List<MediaType> SUPPORTED_MEDIA_TYPES = Arrays.asList(MediaType.APPLICATION_JSON_TYPE, MediaType
      .APPLICATION_XML_TYPE);
}
