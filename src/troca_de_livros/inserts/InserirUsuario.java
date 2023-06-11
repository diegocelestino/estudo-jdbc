package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirUsuario {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        String nome_usuario = "Dan Brown";
        String localizacao_usuario = "Londres";
        String cpf_usuario = "14526673512";
        String email_usuario = "dan@brown.com";
        String telefone_usuario = "1456767876";
        String senha = "************";


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO usuario (nome_usuario, 
                                    localizacao_usuario, 
                                    cpf_usuario, 
                                    email_usuario,
                                    telefone_usuario,
                                    senha)
            VALUES (?, ?, ?, ?, ?, ?);
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nome_usuario);
        statement.setString(2, localizacao_usuario);
        statement.setString(3, cpf_usuario);
        statement.setString(4, email_usuario);
        statement.setString(5, telefone_usuario);
        statement.setString(6, senha);
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Usuario inserido com sucesso");
        } else {
            System.out.println("Falha ao inserir o usuario");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
