import java.sql.*;

public class RegisterAdmin {
    static final String DB_URL = "jdbc:mysql://localhost/u_210165588_ecommerce";
    static final String USER = "root";
    static final String PASS = "password"; // Replace with your actual password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query to insert a new admin
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO admin (name, email, password, address, phone) " +
                         "VALUES ('John Doe', 'johndoe@example.com', 'password', '123 Main St', '555-1234')";
            stmt.executeUpdate(sql);

            System.out.println("Record inserted successfully!");

        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if(stmt != null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn != null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
