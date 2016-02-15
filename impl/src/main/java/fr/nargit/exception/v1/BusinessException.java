package fr.nargit.exception.v1;

/**
 * (c) 14-févr.-2016
 *
 * @author tigran-mac
 */
public class BusinessException extends Exception {
  private Integer code;

  public BusinessException(Integer code, String message) {
    super(message);
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }
}
