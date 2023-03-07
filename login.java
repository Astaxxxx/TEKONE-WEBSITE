import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost/u_210165588_ecommerce";
        String user = "username";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(2, "admin@example.com");
            stmt.setString(3, "adminpassword");

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}




