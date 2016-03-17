package fr.nargit.ranking.rest.v1.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
@XmlRootElement
public class ErrorMessage {
  public String i18nMessage;
  public String devMessage;

  public ErrorMessage() {
  }

  public ErrorMessage(Throwable exception) {
    this.devMessage = exception.getMessage();
    this.i18nMessage = exception.getMessage();
  }

  public String getI18nMessage() {
    return i18nMessage;
  }

  public String getDevMessage() {
    return devMessage;
  }
}
