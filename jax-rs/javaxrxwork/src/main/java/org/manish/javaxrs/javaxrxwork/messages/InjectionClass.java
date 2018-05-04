package org.manish.javaxrs.javaxrxwork.messages;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injections")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectionClass {

	@GET
	@Path("/annotations") 
	public String getParamsUsingAnnotations(@MatrixParam("param") String MatrixParam,
			@HeaderParam("customHeader") String headerValue) {
		return "Works"+MatrixParam+"\n"+headerValue;
	}
	
	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriinfo, @Context HttpHeaders headers) {
		String info = uriinfo.getAbsolutePath().toString();
		return "Path" + info +"\n"+headers.toString();
	}
}
