package troca_de_livros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizarProposta {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        int id_livro_proponente = 1;
        int id_livro_proposto = 2;
        boolean aceite_da_proposta = true;
        int id = 1;

        //2. Executa a consulta e usa os resultados
        String sql = """
            UPDATE proposta 
            SET id_livro_proponente = ?, id_livro_proposto = ?, aceite_da_proposta = ?
            WHERE id_proposta = ?;
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_livro_proponente);
        statement.setInt(2, id_livro_proposto);
        statement.setBoolean(3, aceite_da_proposta);
        statement.setInt(4, id);
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Proposta atualizada com sucesso");
        } else {
            System.out.println("Falha ao atualizar a proposta");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
