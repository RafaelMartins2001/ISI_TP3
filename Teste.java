import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import Restrictions.*;

public class Teste {
    private static Boolean checkAllMinElementsOnTeam(Connection conn) throws SQLException {
        for(int i = 1; i < 8; i++){
            if(!Restrictions.minElementsOnTeam(conn, i))return false;
        }
        return true;
    }

    private static boolean validDate(Connection conn) throws SQLException {
        String query = "select dtvcomercial, dtaquisicao from vcomercial inner join activo on activo = id";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Date date1 = rs.getDate("dtvcomercial");
            Date date2 = rs.getDate("dtaquisicao");
            return date1.compareTo(date2) >= 0;
        }
        return false;
    }
}
