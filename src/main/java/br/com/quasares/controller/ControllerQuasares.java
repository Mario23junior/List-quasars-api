package br.com.quasares.controller;

import java.util.List;

import br.com.quasares.model.Quasares;
import br.com.quasares.service.ServiceQuasares;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/api/quasares/")
public class ControllerQuasares {

	ServiceQuasares service = new ServiceQuasares();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(Quasares quasares) {
		return service.save(quasares);
	}

	@GET
 	@Produces(MediaType.APPLICATION_JSON)
	public List<Quasares> listAll() {
		return service.findAllData();
	}
	
	@GET
	@Path("{id}")
 	@Produces(MediaType.APPLICATION_JSON)
	public Quasares listId(@PathParam("id") Long id) {
		return service.findById(id);
	}
}
