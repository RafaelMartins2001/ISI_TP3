import Restrictions.Restrictions;

import java.sql.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {

        String jdbcURL = "jdbc:postgresql://10.62.73.22:5432/";
        String username = "l3d36";
        String password = "rafaur36";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(jdbcURL, username, password);

            App.init();
            App.getAnswer(conn);


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
