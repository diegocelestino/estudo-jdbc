package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirLivro {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        Integer id_usuario = 2;
        String nome_livro = "O Oceano no Fim do Caminho";
        String nome_autor_livro = "Neil Gaiman";
        String edicao_livro = "2ª edição";
        String ano_livro = "2019";
        String estado_livro = "usado";
        String imagem_livro = "https://www.sqlitetutorial.net/sqlite-foreign-key/";
        String categoria_livro = "Mistério";


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO livro (id_usuario, 
            nome_livro, 
            nome_autor_livro, 
            edicao_livro,
            ano_livro,
            estado_livro,
            imagem_livro,
            categoria_livro)
            VALUES (?, ?, ?, ?, ?, ?, ?, ? );
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_usuario);
        statement.setString(2, nome_livro);
        statement.setString(3, nome_autor_livro);
        statement.setString(4, edicao_livro);
        statement.setString(5, ano_livro);
        statement.setString(6, estado_livro);
        statement.setString(7, imagem_livro);
        statement.setString(8, categoria_livro);
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Livro inserido com sucesso");
        } else {
            System.out.println("Falha ao inserir o livro");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
