import Restrictions.Restrictions.*;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class App {
        public static void init () {
        System.out.println("Escolha uma das opções:\n1 -> Inserir novo activo\n2 -> Substituir um elemento da equipa\n" +
                "3 -> Colocar um activo fora do serviço\n4 -> Custo total de um activo\n5 -> Listar as pessoas que estão" +
                "a realizar a intervenção na 'válvula de ar condicionado' ou que gera esse activo\n6 -> Nome" +
                "dos activos que 'Manuel Fernandes' geriu ou fez intervenção\n7 -> Todos os responsáveis da equipa que " +
                "são/foram gestores de pelo menos 1 ativo\n8 -> Intervenções programadas para daqui a 1 mês");
    }

        public static void getAnswer (Connection conn) throws SQLException {
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (Objects.equals(answer, 1)) Options.addActive(conn);
        }
}
