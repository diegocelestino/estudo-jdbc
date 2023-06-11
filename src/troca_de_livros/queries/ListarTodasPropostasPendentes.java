package troca_de_livros.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarTodasPropostasPendentes {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql = "SELECT id_proposta, status_da_proposta FROM proposta WHERE status_da_proposta = 'Aguardando resposta';";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            int id_proposta = rs.getInt("id_proposta");
            String status_da_proposta = rs.getString("status_da_proposta");
        

            System.out.println("id: " + id_proposta);
            System.out.println("nome: " + status_da_proposta);
            System.out.println("------------------------");
        }


        //3. Fecha a conexão
        rs.close();
        statement.close();
        connection.close();
    }
}
