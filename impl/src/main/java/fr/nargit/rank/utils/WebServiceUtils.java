package fr.nargit.rank.utils;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Locale;

/**
 * Created by NargiT on 16/02/2016
 */
public class WebServiceUtils {

  public static MediaType supportOf(List<MediaType> requested, List<MediaType> supported, MediaType value) {

    return requested.stream()
        .filter(v -> {
          if (v.getParameters().isEmpty()) {
            return supported.contains(v);
          } else {
            return supported.contains(new MediaType(v.getType(), v.getSubtype()));
          }
        })
        .findFirst()
        .orElseGet(() -> value);
  }

  public static Locale supportOf(List<Locale> requested, List<Locale> supported, Locale value) {
    return requested.stream()
        .filter(supported::contains)
        .findFirst()
        .orElseGet(() -> value);
  }
}
