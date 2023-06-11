package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirUsuarioTroca {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        int id_troca = 1;
        int id_usuario = 2;


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO usuario_troca (id_usuario,
            id_troca)
            VALUES (?, ?);
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_usuario);
        statement.setInt(2, id_troca);
    
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Relação Troca-Usuário inserida com sucesso");
        } else {
            System.out.println("Falha ao inserir a Relação Troca-Usuário");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
