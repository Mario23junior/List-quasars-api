package br.com.quasares.service;

 import java.util.List;

import br.com.quasares.execeptions.ExceptionsReturnObjectErro;
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
			return Response.status(Response.Status.CREATED)
					.entity(quasares).build();
		} catch (Exception ex) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
 			throw new ExceptionsReturnObjectErro("Quasar já resgistrado no banco de dado");
		}

	}
	
	public  List<Quasares> findAllData() {
		try {
			List<Quasares> list = em.createQuery("from Quasares",Quasares.class).getResultList();
			return list;
		}catch(Exception e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
 			throw new ExceptionsReturnObjectErro("Erro ao lista informações");
		}	
	}
	
	public Quasares findById(Long id) {
		try{
 			return em.find(Quasares.class, id);
		}catch (Exception e) {
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
 			throw new ExceptionsReturnObjectErro("Erro ao lista id :"+ id +" informações");
 		}
	}
}
