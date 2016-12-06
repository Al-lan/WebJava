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

		User u = new User("Delta", "741");
		u.setId((long) 4);
		System.out.println("1");
		
		manager.getTransaction().begin();
		System.out.println("2");
		manager.persist(u);
		System.out.println("3");
		manager.getTransaction().commit();
		System.out.println("4");
		
		String hql = "from User";

		List<User> usus = new ArrayList<>();
		usus = manager.createQuery(hql).getResultList();

		for (User user : usus) {
			System.out.println(user.getLogin() + " " + user.getSenha());
		}

		manager.close();
		EMF.close();
		
	}

}
