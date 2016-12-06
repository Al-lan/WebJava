package br.com.produtos.DAO;

import javax.persistence.EntityManager;

import br.com.produtos.model.User;

public class UserDAO {

	private static EntityManager manager = BancoUtil.getInstancia().getEMF().createEntityManager();
	
	public static boolean AutenticarUser(User usuario){
		
		boolean permissao = false;
		
		try {
			
		
			String hql = "select us from User as us where us.login=:login and us.senha=:senha";
			
			User aux = (User) manager.createQuery(hql).setParameter(
					"login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();
			
			if( aux != null){
			
				permissao = true;
				usuario.setId(aux.getId());
				System.out.println(usuario.getId());
			
			}
			
		} catch (javax.persistence.NoResultException e) {
			System.out.println("Usuario Não Encontrado");
			e.printStackTrace();
		
		} catch (Exception e) {
			System.out.println("Erro : AutenticarUser");
			e.printStackTrace();
		}
		
		return permissao;
	}
	
	public static void CreateUser(User usuario){
		
		try {
			
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Erro : CreateUser");
			e.printStackTrace();
		}
		
	}
	
	

}
