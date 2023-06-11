package troca_de_livros.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args) throws SQLException {
        //1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";
        Connection connection = DriverManager.getConnection(url);


        //2. Executa a consulta e usa os resultados
        String sql_create_usuario = """
            CREATE TABLE usuario(
                id_usuario INTEGER PRIMARY KEY,
                nome_usuario TEXT, 
                localizacao_usuario TEXT,
                cpf_usuario TEXT,
                email_usuario TEXT,
                telefone_usuario TEXT,
                senha TEXT
            );
        """; 

        String sql_create_livro = """
            CREATE TABLE livro(
                id_livro INTEGER PRIMARY KEY,
                id_usuario INTEGER,
                nome_livro TEXT,
                nome_autor_livro TEXT,
                edicao_livro TEXT,
                ano_livro TEXT,
                estado_livro TEXT,
                imagem_livro TEXT,
                categoria_livro INTEGER,
                FOREIGN KEY (id_usuario)
                    REFERENCES usuario (id_usuario)
            );
        """;

        String sql_create_proposta = """
            CREATE TABLE proposta(
                id_proposta INTEGER PRIMARY KEY,
                id_livro_proponente INTEGER,
                id_livro_proposto INTEGER,
                status_da_proposta TEXT,
                FOREIGN KEY (id_livro_proponente)
                    REFERENCES livro (id_livro),
                FOREIGN KEY (id_livro_proposto)
                    REFERENCES livro (id_livro)
            );
        """;

        String sql_create_troca = """
            CREATE TABLE troca(
                id_troca INTEGER PRIMARY KEY,
                id_livro_proponente INTEGER,
                id_livro_proposto INTEGER,
                status_da_troca TEXT,
                local_da_troca TEXT,
                FOREIGN KEY (id_livro_proponente)
                    REFERENCES livro (id_livro),
                FOREIGN KEY (id_livro_proposto)
                    REFERENCES livro (id_livro)
            );
        """;

        String sql_create_mensagem = """
            CREATE TABLE mensagem(
                id_mensagem INTEGER PRIMARY KEY,
                id_troca INTEGER,
                id_usuario INTEGER,
                texto_da_mensagem TEXT,
                data_da_mensagem TEXT,
                hora_da_mensagem TEXT,
                status_da_mensagem TEXT,
                FOREIGN KEY (id_troca)
                    REFERENCES troca (id_troca),
                FOREIGN KEY (id_usuario)
                    REFERENCES usuario (id_usuario)
            );
        """;

        String sql_create_usuario_proposta = """
            CREATE TABLE usuario_proposta(
                id_usuario INTEGER,
                id_proposta INTEGER,
                FOREIGN KEY (id_usuario)
                    REFERENCES usuario (id_usuario),
                FOREIGN KEY (id_proposta)
                    REFERENCES proposta (id_proposta)
                
            );
        """; 

        String sql_create_usuario_troca = """
            CREATE TABLE usuario_troca(
                id_usuario INTEGER,
                id_troca INTEGER,
                FOREIGN KEY (id_usuario)
                    REFERENCES usuario (id_usuario),
                FOREIGN KEY (id_troca)
                    REFERENCES troca (id_troca)
                
            );
        """; 

        Statement statement = connection.createStatement();
        statement.execute(sql_create_usuario_troca);


        //3. Fecha a conexão
        statement.close();
        connection.close();
    }
}
