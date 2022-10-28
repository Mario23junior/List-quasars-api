package br.com.quasares.execeptions;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Produces("application/json")
@Provider
public class HandlerErroResponse implements ExceptionMapper<ExceptionsReturnObjectErro> {

	public Response toResponse(ExceptionsReturnObjectErro ex) {
 		return Response.status(404)
 				.entity(ex.getMessage())
 				.type(MediaType.APPLICATION_JSON)
 				.build();
	}

}
