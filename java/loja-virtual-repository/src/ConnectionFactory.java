import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionFactory {
	
	public DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("toor");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.datasource = comboPooledDataSource;
	}
	public Connection recuperarConexao() throws SQLException {
		return this.datasource.getConnection();
				
			
		
	}
}
