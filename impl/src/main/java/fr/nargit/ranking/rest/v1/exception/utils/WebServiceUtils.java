package fr.nargit.ranking.rest.v1.exception.utils;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

/**
 * Created by NargiT on 16/02/2016
 */
public class WebServiceUtils {

  public static MediaType supportOf(List<MediaType> requested, List<MediaType> supported, MediaType defaultMediaType) {

    Optional<MediaType> mediaType = requested.stream()
        .filter(v -> {
          if (v.getParameters().isEmpty()) {
            return supported.contains(v);
          } else {
            return supported.contains(new MediaType(v.getType(), v.getSubtype()));
          }
        })
        .findFirst();

    return mediaType.isPresent() ? mediaType.get() : defaultMediaType;
  }
}
