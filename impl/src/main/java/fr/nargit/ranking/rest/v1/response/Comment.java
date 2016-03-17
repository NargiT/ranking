package fr.nargit.ranking.rest.v1.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by NargiT on 28/02/2016
 */
@XmlRootElement
public class Comment {
  public Integer id;
  public String author;
  public String text;
}
