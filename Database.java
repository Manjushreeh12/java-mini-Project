package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import View.Alert;

public class Database {
	
	private String user = "root";
	private String pass = "root";
	private String url = "jdbc:mysql://localhost:3306/socialmedia";
	private Statement statement;
	
	public Database() {
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			new Alert(e.getMessage(), null);
		}
	}
	
	public Statement getStatement() {
		return statement;
	}

}
