package troca_de_livros.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql = """
            DROP TABLE mensagem;
        """;

        Statement statement = connection.createStatement();
        statement.execute(sql);


        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
