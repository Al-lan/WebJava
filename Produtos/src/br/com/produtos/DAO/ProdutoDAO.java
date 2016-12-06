package br.com.produtos.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.produtos.model.Produto;


public class ProdutoDAO {

	private static EntityManager manager = BancoUtil.getInstancia().getEMF().createEntityManager();
	
	public ProdutoDAO() {
	}

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
}
