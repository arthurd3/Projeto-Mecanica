package mecanica.servicos.gerenciamentoServicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicoManager {
  private List<Servico> listaServicos = new ArrayList<>();

  private Scanner scanner = new Scanner(System.in);

  public void cadastrarServico() {
    System.out.println("Cadastrando Servico :\n");

    System.out.println("Digite o nome do Servico: ");
    var nomeServico = scanner.nextLine();

    System.out.println("Digite o preco do Servico: ");
    var precoServico = scanner.nextDouble();

    Servico servico = new Servico(nomeServico , precoServico);

    listaServicos.add(servico);

    System.out.println("Serviço cadastrado: " + servico);
  }

  public void atualizarServico(int id, String novoNome, double novoPreco) {
    var servico = buscarServicoPorId(id);

    if (servico == null) {
      System.out.println("Serviço com ID " + id + " não encontrado.");
    }

    servico.setNome(novoNome);
    servico.setPreco(novoPreco);

    System.out.println("Serviço atualizado: " + servico);
  }

  public void deletarServico(int id) {

    Servico servico = buscarServicoPorId(id);

    if (buscarServicoPorId(id) == null) {
      System.out.println("Serviço com ID " + id + " não encontrado.");

    }

    listaServicos.remove(servico);
    System.out.println("Serviço deletado: " + servico);
  }

  public Servico buscarServicoPorId(int id) {
    for (Servico servico : listaServicos) {
      if (servico.getId() == id) {
        return servico;
      }
    }
    return null;
  }

  public void listarServicos() {
    if (!listaServicos.isEmpty()) {
      System.out.println("Serviços cadastrados:");
      for (Servico servico : listaServicos) {
        System.out.println(servico);
      }
    }
    System.out.println("Nenhum serviço cadastrado.");
  }

}
