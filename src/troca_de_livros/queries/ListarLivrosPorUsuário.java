package troca_de_livros.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarLivrosPorUsuário {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql = "SELECT id_livro, nome_livro  FROM livro WHERE id_usuario = 2;";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            int id_livro = rs.getInt("id_livro");
            String nome_livro = rs.getString("nome_livro");
        

            System.out.println("id: " + id_livro);
            System.out.println("nome: " + nome_livro);
            System.out.println("------------------------");
        }


        //3. Fecha a conexão
        rs.close();
        statement.close();
        connection.close();
    }
}
