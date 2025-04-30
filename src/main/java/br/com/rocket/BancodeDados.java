package br.com.rocket;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BancodeDados {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/rocket_db";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "1234");
            //props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Conexão estabelecida com sucesso!");

            String sql = "INSERT INTO public.tab_cadastro (nome,idade) VALUES (?,?)";
            String nome = "Felipe";
            Integer idade = 13;

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,nome);
            pst.setInt(2,idade);
            pst.execute();
            System.out.println("Dados inseridos com sucesso!");

        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }

}
