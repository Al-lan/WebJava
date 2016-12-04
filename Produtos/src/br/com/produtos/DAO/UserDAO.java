package br.com.produtos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.produtos.model.User;

public class UserDAO {
	
	public static boolean Autenticar(User usuario){
		
		boolean permissao = false;
		
		try {
			
			Connection con = BancoUtil.getConection();
			
			String sql = "select login, senha from users_prod where login=? and senha=? ;";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			
			ResultSet re = pstm.executeQuery();
			
			if(re.next()){
				permissao = true;
			}
			
			re.close();
			pstm.close();
			
			
		} catch (Exception e) {
			System.out.println("Erro : Autenticar");
			e.printStackTrace();
		}
		
		return permissao;
	}

}
