package com. manual;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TekoneDatabaseConnection {

private final String ULConnection;
private final String username;
private final String password;
private static ManualDatabaseConnection instance;

private ManualDatabaseConnection0 {
URLConnection = "jdbc:mysql://localhost :3306 /Tekone";/// the location and the path for the database
username = "root";
password =
}

public Connection getConnection() {
try {
return DriverManager. getConnection(URLConnection, username, password) ;
}
catch (SQLException e) {
System,err ,println("Failed to connect to the database: " + e. getMessage ()) ;

}
return null;
}
public static TekoneDatabaseConnection getInstance() {
if (instance == null) {
instance = new ManualDatabaseConnection();
}
return instance;
}
}