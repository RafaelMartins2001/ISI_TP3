package Restrictions;
import java.sql.*;
import java.util.Date;

public class Restrictions {
    /**
     * @param conn
     * @param elementID
     * @return Returns true if the person with the id "elementID" is part of a team with more than 2 elements.
     * or false if otherwise
     * @throws SQLException
     */
    public static Boolean minTwoElements(Connection conn, int elementID) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = null;
        String teamCodeQuery = "select equipa from pessoa where id = " + elementID;
        rs = stmt.executeQuery(teamCodeQuery);
        rs.next();
        int code = rs.getInt(1);
        System.out.println(code);
        String query = "select equipa from pessoa";
        rs = stmt.executeQuery(query);
        int count = 0;
        while (rs.next()) {
            if (code == rs.getInt("equipa")) count++;
        }
        return count > 2;
    }

    /**
     * @param conn
     * @param teamCode
     * @return Returns true if the team with the code "teamCode" has 2 or more elements, otherwise returns false.
     * @throws SQLException
     */
    public static Boolean minElementsOnTeam(Connection conn, int teamCode) throws SQLException {
        String query = "select equipa from pessoa";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int count = 0;
        while (rs.next()) {
            if (teamCode == rs.getInt("equipa")) count++;
        }
        return count >= 2;
    }

    /**
     * @param conn
     * @param activo
     * @param dtvcomercial
     * @return Returns true if the "dtvcomercial" passed in the arguments from a certain "activo" is greater or equal than it's dtaquisicao.
     * @throws SQLException
     */
    public static Boolean validDate(Connection conn, String activo, java.sql.Date dtvcomercial) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs;
        String query = "select dtaquisicao from activo where id = " + activo;
        rs = stmt.executeQuery(query);
        while(rs.next()) {
            return (dtvcomercial.compareTo(rs.getDate(1)) >= 0);
        }
        return false;
    }

}
