package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirProposta {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        int id_livro_proponente = 3;
        int id_livro_proposto = 6;
        String status_da_proposta = "Aguardando resposta";


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO proposta (id_livro_proponente, 
            id_livro_proposto, 
            status_da_proposta)
            VALUES (?, ?, ?);
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_livro_proponente);
        statement.setInt(2, id_livro_proposto);
        statement.setString(3, status_da_proposta);
    
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Proposta inserida com sucesso");
        } else {
            System.out.println("Falha ao inserir a proposta");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
