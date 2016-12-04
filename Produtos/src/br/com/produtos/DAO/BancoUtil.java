package br.com.produtos.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoUtil {
	
	private static Connection conection;
	
	static {
		
		 try {
			 
		     Class.forName("org.hsqldb.jdbc.JDBCDriver");
		     
		 } catch (Exception e) {
		     System.err.println("Erro : driver.");
		     e.printStackTrace();
		 }

		 try {
			 
			conection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/prod", "SA", "");
			
		 } catch (SQLException e) {
			System.out.println("Erro : Conexão");
			e.printStackTrace();
		 }
	}

	public static Connection getConection() {
		return conection;
	}
	
}
