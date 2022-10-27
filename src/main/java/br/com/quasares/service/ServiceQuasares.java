package br.com.quasares.service;

import br.com.quasares.model.Quasares;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.core.Response;

public class ServiceQuasares {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceData");
	EntityManager em = emf.createEntityManager();

	public Response save(Quasares quasares) {
		try {
			this.em.getTransaction().begin();
			this.em.persist(quasares);
			this.em.getTransaction().commit();
			Response.ok().build();
			return Response.status(Response.Status.CREATED).entity(quasares).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}

	}
}
