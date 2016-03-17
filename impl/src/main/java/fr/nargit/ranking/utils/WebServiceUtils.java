package fr.nargit.ranking.utils;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

/**
 * Created by NargiT on 16/02/2016
 */
public class WebServiceUtils {

  public static Optional<MediaType> supportOf(List<MediaType> requested, List<MediaType> supported, MediaType defaultMediaType) {

    return requested.stream()
        .filter(v -> {
          if (v.getParameters().isEmpty()) {
            return supported.contains(v);
          } else {
            return supported.contains(new MediaType(v.getType(), v.getSubtype()));
          }
        })
        .findFirst();
  }
}
