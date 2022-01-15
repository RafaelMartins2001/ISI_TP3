import Restrictions.Restrictions;

import java.sql.*;
import java.text.*;

public class App {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:postgresql://10.62.73.22:5432/";
        String username = "l3d36";
        String password = "rafaur36";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // JDBC and PostgreSQL: https://jdbc.postgresql.org/
            // PostgreSQL: https://www.postgresql.org/docs/7.4/jdbc-use.html

            // Step 1 - Load driver
            // Class.forName("org.postgresql.Driver"); // Class.forName() is not needed since JDBC 4.0

            // Step 2 -  Connecting to the Database
            conn = DriverManager.getConnection(jdbcURL, username, password);

            // Step 3 - Execute statement 1
            stmt = conn.createStatement();

            rs = stmt.executeQuery("select id from activo");
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

            // Step 4 - Get result
            while (rs.next()) {
                System.out.println(rs.getString("id"));
            }

            System.out.println(Restrictions.validDate(conn, "'k4568'", Date.valueOf("2021-04-30")));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5 Close connection
            try {
                // free the resources of the ResultSet
                if (rs != null) rs.close();
                // free the resources of the Statement
                if (stmt != null) stmt.close();
                // close connection
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
