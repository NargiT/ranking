package fr.nargit.rank.rest.v1.resource.response;

import fr.nargit.rank.rest.v1.exception.BusinessException;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
@XmlRootElement
public class ErrorMessage {
  public Integer code;
  public String i18nMessage;
  public String devMessage;

  public ErrorMessage() {
  }

  public ErrorMessage(BusinessException exception) {
    this.code = exception.getCode();
    this.devMessage = exception.getMessage();
    this.i18nMessage = getI18nMessage(code);
  }

  private String getI18nMessage(Integer code) {
    ResourceBundle messagesBundle = ResourceBundle.getBundle("MessagesBundle", Locale.FRANCE);
    if (messagesBundle == null) {
      return String.format("%d - translation is missing", code);
    }
    // FIXME : make sur the encoding is correct
    return String.format("%d - %s", code, messagesBundle.getString(String.valueOf(code)));
  }

  public ErrorMessage(WebApplicationException exception) {
    this.code = exception.getResponse().getStatus();
    this.devMessage = exception.getMessage();
    this.i18nMessage = getI18nMessage(code);
  }

  public ErrorMessage(Throwable exception) {
    this.code = 1000;
    this.devMessage = "This is a golden exception, report this problem to the dev !";
    this.i18nMessage = getI18nMessage(code);
  }

  public Integer getCode() {
    return code;
  }

  public String getI18nMessage() {
    return i18nMessage;
  }

  public String getDevMessage() {
    return devMessage;
  }
}
