package org.manish.javaxrs.javaxrxwork;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

@Path("/")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class CommentResource {


	@GET
	public String test() {
		return "new sub resource";
	}
	
	@GET
	@Path("/{commentID}") 
	public String test2(@PathParam("messageId") long msgId) {
		return "method to return Comment ID"+msgId;
		
	}
}

