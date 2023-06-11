package troca_de_livros.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarPropostasPorUsuario {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql = "SELECT * FROM usuario_proposta WHERE id_usuario = 2;";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            int id_usuario = rs.getInt("id_usuario");
            int id_proposta = rs.getInt("id_proposta");       

            System.out.println("id usuario: " + id_usuario);
            System.out.println("id proposta: " + id_proposta);
            System.out.println("------------------------");
        }


        //3. Fecha a conexão
        rs.close();
        statement.close();
        connection.close();
    }
}
