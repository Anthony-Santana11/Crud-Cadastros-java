package br.com.rocket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;
    public CadastroRepository() {
        this.conexao = ServerConexao.getConexao();
    }
    public void inserir(Cadastro cadastro){
        String instrucaosql = "INSERT INTO public.tab_cadastro (nome,idade) VALUES (?,?)";
        PreparedStatement stmt = null;
        try {

            stmt = conexao.prepareStatement(instrucaosql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getIdade());
            stmt.execute();
            System.out.println("Os dados foram inseridos com sucesso!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void atualizar(Cadastro cadastro){
        String instrucaosql = "UPDATE public.tab_cadastro SET nome = ?, idade = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(instrucaosql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, cadastro.getIdade());
            stmt.setInt(3, cadastro.getId());
            stmt.execute();
            System.out.println("Os dados foram atualizados com sucesso!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void excluir(Integer id){
        String instrucaosql = "DELETE FROM public.tab_cadastro WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(instrucaosql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Os dados foram deletados com sucesso!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public List<Cadastro> listarTodos(){
        String instrucaosql = "SELECT * FROM public.tab_cadastro";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(instrucaosql);
            ResultSet rs = stmt.executeQuery();
            List<Cadastro> cadastros = new ArrayList<>();
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setId(rs.getInt("id"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setIdade(rs.getInt("idade"));
                cadastros.add(cadastro);
            }
            return cadastros;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public void buscarPorId(){
        String instrucaosql = "SELECT * FROM public.tab_cadastro WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(instrucaosql);
            stmt.setInt(1, 1);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cadastro cadastro = new Cadastro();
                cadastro.setId(rs.getInt("id"));
                cadastro.setNome(rs.getString("nome"));
                cadastro.setIdade(rs.getInt("idade"));
                System.out.println(cadastro.getId() + " " + cadastro.getNome() + " " + cadastro.getIdade());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

