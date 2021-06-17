package Alura;
import java.sql.Connection;

import java.sql.SQLException;
public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.recuperarConexao();
	
	System.out.println("Fechando conexao");
	con.close();
	}

}
