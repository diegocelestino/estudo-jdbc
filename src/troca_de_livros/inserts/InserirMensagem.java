package troca_de_livros.inserts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirMensagem {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);

        Integer id_troca = 1;
        Integer id_usuario = 1;
        String texto_da_mensagem = "Bom dia, tudo bem?";
        String data_da_mensagem = "10/06/2023";
        String hora_da_mensagem = "10:52";
        String status_da_mensagem = "não lida";


        //2. Executa a consulta e usa os resultados
        String sql = """
            INSERT INTO mensagem (id_troca, 
            id_usuario, 
            texto_da_mensagem, 
            data_da_mensagem,
            hora_da_mensagem,
            status_da_mensagem)
            VALUES (?, ?, ?, ?, ?, ?);
        """;

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id_troca);
        statement.setInt(2, id_usuario);
        statement.setString(3, texto_da_mensagem);
        statement.setString(4, data_da_mensagem);
        statement.setString(5, hora_da_mensagem);
        statement.setString(6, status_da_mensagem);
        
        
        int linhasAfetadas = statement.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Mensagem inserida com sucesso");
        } else {
            System.out.println("Falha ao inserir mensagem");
        }

        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
