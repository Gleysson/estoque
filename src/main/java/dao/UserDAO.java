package dao;

import javax.persistence.EntityManager;
import utils.JPAUtil;
import beans.User;

public class UserDAO {
	private EntityManager manager;
	
	public UserDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public void addUser (User user) {
		this.manager.getTransaction().begin();
		this.manager.persist(user);
		this.manager.getTransaction().commit();
	}
	
	public Boolean login(User user) {
		Boolean auth = false;
    	System.out.println(user.getLogin()+" - "+user.getPassword());

    	User userResponse = this.manager.createQuery("User.login", User.class)
            .setParameter("login", user.getLogin())
            .setParameter("password", user.getPassword())
            .getSingleResult();
    	
    	if( userResponse != null ){
		  auth = true;
		}
    	
    	return auth;
    }
	
	public User getUserById(int id) {
		return manager.find(User.class, id);
    }
	
	public void deleteUser(int id) {
		User user = manager.find(User.class, id);
		this.manager.remove(user);
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
    }

	public void updateUser(User user) {
		this.manager.persist(user);
		this.manager.getTransaction().begin();
		this.manager.getTransaction().commit();
	}
	
	public void close() {
		this.manager.close();
	}
}
