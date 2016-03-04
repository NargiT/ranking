package fr.nargit.rank.rest.v1.resource;

import fr.nargit.rank.rest.v1.resource.response.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("comments")
public class CommentResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(CommentResource.class);

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  @Path("{id}")
  public Comment getComment(@PathParam("id") String id) {
    LOGGER.info("Requesting one comment");
    Comment comment = buildComment(1);
    return comment;
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public List<Comment> getComments(
      @DefaultValue("5")
      @QueryParam("limit") Integer limit) {
    LOGGER.info("Requesting {} comment", limit);

    List<Comment> comments = new LinkedList<>();
    for (int i = 0; i < limit; i++) {
      comments.add(buildComment(i));
    }
    return comments;
  }

  private Comment buildComment(Integer id) {
    Comment comment = new Comment();
    comment.id = id;
    comment.author = "Tigran";
    comment.text = "Hello dude !" + id;
    return comment;
  }

}
