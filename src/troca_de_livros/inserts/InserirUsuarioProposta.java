package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirUsuarioProposta {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        int id_proposta = 4;
        int id_usuario = 4;


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO usuario_proposta (id_usuario,
            id_proposta)
            VALUES (?, ?);
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_usuario);
        statement.setInt(2, id_proposta);
    
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Relação Proposta-Usuário inserida com sucesso");
        } else {
            System.out.println("Falha ao inserir a Relação Proposta-Usuário");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
