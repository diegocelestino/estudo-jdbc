package troca_de_livros.queries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListarMensagensPorUsuario {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql = "SELECT id_mensagem, id_troca, id_usuario, texto_da_mensagem from mensagem WHERE id_usuario = 1";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()) {
            int id_mensagem = rs.getInt("id_mensagem");
            int id_troca = rs.getInt("id_troca");
            int id_usuario = rs.getInt("id_usuario");
            String texto_da_mensagem = rs.getString("texto_da_mensagem");
        

            System.out.println("id mensagem: " + id_mensagem);
            System.out.println("id troca: " + id_troca);
            System.out.println("id usuario: " + id_usuario);
            System.out.println("texto da mensagem: " + texto_da_mensagem);
            System.out.println("------------------------");
        }


        //3. Fecha a conexão
        rs.close();
        statement.close();
        connection.close();
    }
}
