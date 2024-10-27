import java.util.ArrayList;
import java.util.List;

public class ServicoManager {
  private List<Servico> listaServicos = new ArrayList<>();
  private int proximoId = 1;

  // Cadastrar um novo serviço
  public void cadastrarServico(String nome, double preco) {
    Servico servico = new Servico(proximoId++, nome, preco);
    listaServicos.add(servico);

    System.out.println("Serviço cadastrado: " + servico);
  }

  // Atualizar um serviço existente
  public void atualizarServico(int id, String novoNome, double novoPreco) {
    Servico servico = buscarServicoPorId(id);
    if (servico != null) {
      servico.setNome(novoNome);
      servico.setPreco(novoPreco);

      System.out.println("Serviço atualizado: " + servico);
    } else {
      System.out.println("Serviço com ID " + id + " não encontrado.");
    }
  }

  // Deletar um serviço
  public void deletarServico(int id) {
    Servico servico = buscarServicoPorId(id);
    if (servico != null) {
      listaServicos.remove(servico);

      System.out.println("Serviço deletado: " + servico);
    } else {
      System.out.println("Serviço com ID " + id + " não encontrado.");
    }
  }

  // Buscar um serviço por ID
  public Servico buscarServicoPorId(int id) {
    for (Servico servico : listaServicos) {
      if (servico.getId() == id) {
        return servico;
      }
    }
    return null;
  }

  // Listar todos os serviços
  public void listarServicos() {
    if (listaServicos.isEmpty()) {
      System.out.println("Nenhum serviço cadastrado.");
    } else {
      System.out.println("Serviços cadastrados:");
      for (Servico servico : listaServicos) {
        System.out.println(servico);
      }
    }
  }
}
