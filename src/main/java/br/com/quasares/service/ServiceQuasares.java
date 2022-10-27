package br.com.quasares.service;

import br.com.quasares.model.Quasares;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.core.Response;

public class ServiceQuasares {
  
	EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("persistenceData");
	EntityManager em = emf.createEntityManager();
	
	public Quasares save(Quasares quasares) {
		this.em.getTransaction().begin();
		this.em.persist(quasares);
		this.em.getTransaction().commit();
		Response.ok().build();
		return quasares;
	}
}
