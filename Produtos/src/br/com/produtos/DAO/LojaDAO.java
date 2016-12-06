package br.com.produtos.DAO;

import javax.persistence.EntityManager;

import br.com.produtos.model.Loja;

public class LojaDAO {
	
	private static EntityManager manager = BancoUtil.getInstancia().getEMF().createEntityManager();
	
	public static Loja readLoja(Long id){
		
		Loja loja = null;
		
		try {
			
			String hql = "select l from Loja as l where l.id=:id";
			
			loja = (Loja) manager.createQuery(hql).setParameter("id", id).getSingleResult();
			
			
		} catch (Exception e) {
			System.out.println("Erro : ReadLoja");
			e.printStackTrace();
		}
		
		return loja;
		
	}
	
	public static void createLoja(Loja loja) {
		
		try {
			
			manager.getTransaction().begin();
			manager.persist(loja);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Erro: CreateLoja");
			e.printStackTrace();
		}
		
	}
	
	public static boolean autenticarLoja(Loja loja){
		
		boolean permissao = false;
		
		try {
			
			
			String hql = "select lo from Loja as lo where lo.cnpj=:cnpj and lo.senha=:senha";
			
			System.out.println(loja.getCnpj()+" "+loja.getSenha());
			
			Loja aux = (Loja) manager.createQuery(hql).setParameter(
					"cnpj", loja.getCnpj()).setParameter("senha", loja.getSenha()).getSingleResult();
			
			if( aux != null){
			
				permissao = true;
				loja.setId(aux.getId());
				loja.setNome(aux.getNome());
				System.out.println("  "+aux.getNome());
			
			}
			
		} catch (javax.persistence.NoResultException e) {
			System.out.println("Loja Não Encontrada");
			e.printStackTrace();
		
		} catch (Exception e) {
			System.out.println("Erro : AutenticarLoja");
			e.printStackTrace();
		}
			
		return permissao;
		
	}

}
