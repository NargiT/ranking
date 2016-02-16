package fr.nargit.rank.rest.v1.resource.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * (c) 03-févr.-2016
 *
 * @author tigran-mac
 */

@XmlRootElement
public class DummyObject {
  public String username;
  public String greeting;

  public DummyObject() {
  }

  public DummyObject(String username, String greeting) {
    this.username = username;
    this.greeting = greeting;
  }
}
