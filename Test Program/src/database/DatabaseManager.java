package database;


import java.sql.*;


public class DatabaseManager {
	
	public DatabaseManager(){
		openConnection();
	}
	
	public void openConnection(){
		try {
//            Class.forName("org.h2.Driver");
//            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//            stmt = connection.createStatement();
//            stmt.execute(CREATE_TABLE);
        } catch (Exception ex) {
        }
	}

}
