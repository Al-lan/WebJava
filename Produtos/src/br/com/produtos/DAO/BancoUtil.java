package br.com.produtos.DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

public class BancoUtil {
	
	@PersistenceUnit
	private EntityManagerFactory EMF = Persistence.createEntityManagerFactory("PRD");
	
	private static BancoUtil instancia;
	
	private BancoUtil() {
		
	}
	
	public static BancoUtil getInstancia(){
		
		if(instancia == null ){
			instancia = new BancoUtil();		
		}
		
		return instancia;
	}

	public EntityManagerFactory getEMF() {
		return EMF;
	}

	
	
	
}
