package br.com.produtos.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.produtos.model.Produto;


public class ProdutoDAO {

	private static EntityManager manager = BancoUtil.getInstancia().getEMF().createEntityManager();
	
	public static void create(Produto produto) {
		try {
			
			manager.getTransaction().begin();
			manager.persist(produto);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Erro : CreateUser");
			e.printStackTrace();
		}
	}

	public List<Produto> getLista() {
		List<Produto> produtos = (List<Produto>) manager.createQuery("from Produto").getResultList();
		return produtos;
	}
	
	public static void deleteProduto(long id){
		
		try{
			manager.getTransaction().begin();
			manager.remove(manager.find(Produto.class, id));
			manager.getTransaction().commit();
			
		}catch (Exception e) {
			System.out.println("Erro : deleteProduto ");
			e.printStackTrace();
		}
	}
	
	public static void deleteProdutosLoja(long loja){
		
		try{
			System.out.println("1");
			
			String hql = "delete from Produto as po where po.loja=:loja";
			
			System.out.println("2");
			
			manager.getTransaction().begin();

			manager.createQuery(hql).setParameter("loja", LojaDAO.readLoja(loja)).executeUpdate();
		
			manager.getTransaction().commit();
			
			System.out.println("5");

			
		}catch (Exception e){
			System.out.println("Erro : deleteProdutosLoja");
			e.printStackTrace();
		}
		
	}
}
