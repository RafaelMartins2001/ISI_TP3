import java.sql.*;
import java.util.Scanner;

public class Options {
    public static void addActive(Connection conn) throws SQLException {
        String cmdIns = "insert into activo values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(cmdIns);
        String id = readInput("id:");
        String nome = readInput("nome:");
        String estado = readInput("estado:");
        String dtaquisicao = readInput("dtaquisicao:");
        String modelo = readInput("modelo:");
        String marca = readInput("marca:");
        String localizacao = readInput("localizacao:");
        String idactivotopo = readInput("idactivotopo:");
        String tipo = readInput("tipo:");
        String empresa = readInput("empresa:");
        String pessoa = readInput("pessoa:");
        pstmt.setString(1, id);
        pstmt.setString(2, nome);
        pstmt.setString(3, estado);
        pstmt.setString(4, dtaquisicao);
        pstmt.setString(5, modelo);
        pstmt.setString(6, marca);
        pstmt.setString(7, localizacao);
        pstmt.setString(8, idactivotopo);
        pstmt.setString(9, tipo);
        pstmt.setString(10, empresa);
        pstmt.setString(11, pessoa);
        pstmt.close();
    }
    
    private static String readInput(String request) {
        System.out.print(request);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
