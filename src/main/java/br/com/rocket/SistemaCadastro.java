package br.com.rocket;

import java.util.List;

public class SistemaCadastro {
   public static void main(String[] args) {
      ServerConexao.conectar();
      CadastroRepository repository = new CadastroRepository();
      List<Cadastro> cadastros = repository.listarTodos();
      for (Cadastro cadastro : cadastros) {
         System.out.println(cadastro.getId() + " " + cadastro.getNome() + " " + cadastro.getIdade());
      }
   }

}
