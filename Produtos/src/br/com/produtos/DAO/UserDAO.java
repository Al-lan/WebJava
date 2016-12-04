package br.com.produtos.DAO;



import javax.persistence.EntityManager;

import br.com.produtos.model.User;

public class UserDAO {

	private static EntityManager EM = BancoUtil.getInstancia().getEMF().createEntityManager();
	
	public static boolean Autenticar(User usuario){
		
		boolean permissao = false;
		
		try {
			
		
			String hql = "select us from User as us where us.login=:login and us.senha=:senha";
			
			User aux = (User) EM.createQuery(hql).setParameter(
					"login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();
			
			if( aux != null){
			
				permissao = true;
				usuario.setId(aux.getId());
				System.out.println(usuario.getId());
			
			}
			
		} catch (Exception e) {
			System.out.println("Erro : Autenticar");
			e.printStackTrace();
		}
		
		return permissao;
	}

}
