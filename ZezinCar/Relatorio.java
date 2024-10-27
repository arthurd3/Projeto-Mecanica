import java.util.HashMap;
import java.util.Map;

public class Relatorio {
  private Map<String, Double> arrecadacaoPorServico;
  private int totalClientesAtendidos;

  public Relatorio() {
    this.arrecadacaoPorServico = new HashMap<>();
    this.totalClientesAtendidos = 0;
  }

  // ADICIONA UM SERVICO AO RELATORIO
  public void adicionarServico(String nomeServico, double preco) {
    arrecadacaoPorServico.put(nomeServico, arrecadacaoPorServico.getOrDefault(nomeServico, 0.0) + preco);
  }

  // INCREMENTA O CONTADOR AOS CLIENTES ATENDIDOS
  public void incrementarClientesAtendidos() {
    totalClientesAtendidos++;
  }

  // GERA RELATORIO
  public void gerarRelatorio() {
    System.out.println("Relatório de Serviços Realizados:");
    for (Map.Entry<String, Double> entry : arrecadacaoPorServico.entrySet()) {
      System.out.println("Serviço: " + entry.getKey() + ", Total Arrecadado: R$" + entry.getValue());
    }
    System.out.println("Total de Clientes Atendidos: " + totalClientesAtendidos);
  }
}
