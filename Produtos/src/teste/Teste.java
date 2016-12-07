package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.produtos.DAO.UserDAO;
import br.com.produtos.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teste {
	
  
	
	public static void main(String[] args) {
		
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PRD");
		
		EntityManager manager = EMF.createEntityManager();

		
		String hql = "from User";

		List<User> usus = new ArrayList<>();
		usus = manager.createQuery(hql).getResultList();

		for (User user : usus) {
			System.out.println(user.getLogin() + " " + user.getSenha());
		}
		
	
		
		manager.getTransaction().begin();
		manager.remove(manager.find(User.class, 5L));
		manager.getTransaction().commit();

		
		System.out.println("-----------------");
		
		usus = manager.createQuery(hql).getResultList();

		for (User user : usus) {
			System.out.println(user.getLogin() + " " + user.getSenha());
		}
		
		manager.close();
		EMF.close();
		
	}
	
	
	

}
