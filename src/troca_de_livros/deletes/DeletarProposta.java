package troca_de_livros.deletes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarProposta {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        Integer id = 2;

        //2. Executa a consulta e usa os resultados
        String sql = "DELETE FROM proposta WHERE id_proposta = ?;";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Proposta removida com sucesso");
        } else {
            System.out.println("Falha ao remover a proposta");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
