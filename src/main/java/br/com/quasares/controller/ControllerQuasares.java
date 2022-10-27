package br.com.quasares.controller;

import br.com.quasares.model.Quasares;
import br.com.quasares.service.ServiceQuasares;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/api/quasares/")
public class ControllerQuasares {
  
	ServiceQuasares service = new ServiceQuasares();
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
	public Response save(Quasares quasares) {
		return service.save(quasares);
 	}
}
