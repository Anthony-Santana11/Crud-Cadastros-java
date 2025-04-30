package br.com.rocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import static java.sql.DriverManager.getConnection;


public class ServerConexao {
    private static Connection conexao;
    public static void conectar(){
        try {
            if (conexao == null) {
                String url = "jdbc:postgresql://localhost:5432/rocket_db";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "1234");
                conexao = getConnection(url, props);
                System.out.println("Conexão estabelecida com sucesso!");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConexao() {
        return conexao;
    }

}
