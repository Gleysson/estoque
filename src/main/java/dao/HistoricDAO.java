package dao;

import java.util.List;
import javax.persistence.EntityManager;
import beans.Historic;
import utils.JPAUtil;

public class HistoricDAO {
private EntityManager manager;
	
	public HistoricDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public void addHistoric (Historic Historic) {
		this.manager.getTransaction().begin();
		this.manager.persist(Historic);
		this.manager.getTransaction().commit();
	}
	
	public List<Historic> findAll() {
		return this.manager.createNamedQuery("Historic.findAll").getResultList();
    }
	
	public Historic findByName(String name) {
		Historic Historic = this.manager.createNamedQuery("Historic.findByName", Historic.class)
                .setParameter("name", name)
                .getSingleResult();
        return Historic;
    }
	
	public Historic getHistoricById(int id) {
		return manager.find(Historic.class, id);
    }
	
	public void deleteHistoric(int id) {
		Historic Historic = manager.find(Historic.class, id);
		this.manager.remove(Historic);
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
    }

	public void updateHistoric(Historic Historic) {
		this.manager.persist(Historic);
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
	}
	
	public void close() {
		this.manager.close();
	}
}
