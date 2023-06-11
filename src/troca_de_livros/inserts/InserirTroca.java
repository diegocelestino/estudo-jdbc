package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirTroca {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        int id_livro_proponente = 1;
        int id_livro_proposto = 2;
        String status_da_troca = "Em andamento";
        String local_da_troca = "Estação Armênia";


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO troca (id_livro_proponente, 
            id_livro_proposto, 
            status_da_troca,
            local_da_troca)
            VALUES (?, ?, ?, ?);
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_livro_proponente);
        statement.setInt(2, id_livro_proposto);
        statement.setString(3, status_da_troca);
        statement.setString(4, local_da_troca);
    
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Troca inserida com sucesso");
        } else {
            System.out.println("Falha ao inserir a troca");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
