package troca_de_livros.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarTodosLivros {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql = "SELECT id_troca, local_da_troca  FROM troca WHERE local_da_troca = 'Estação Armênia';";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            int id_troca = rs.getInt("id_troca");
            String local_da_troca = rs.getString("local_da_troca");
        

            System.out.println("id: " + id_troca);
            System.out.println("nome: " + local_da_troca);
            System.out.println("------------------------");
        }


        //3. Fecha a conexão
        rs.close();
        statement.close();
        connection.close();
    }
}
