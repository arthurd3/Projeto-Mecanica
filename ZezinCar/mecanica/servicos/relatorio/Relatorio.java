package mecanica.servicos.relatorio;

import java.util.HashMap;
import java.util.Map;

public class Relatorio {
  private Map<String, Double> arrecadacaoPorServico;
  private int totalClientesAtendidos;

  public Relatorio() {
    this.arrecadacaoPorServico = new HashMap<>();
    this.totalClientesAtendidos = 0;
  }

  public void adicionarServico(String nomeServico, double preco) {
    arrecadacaoPorServico.put(nomeServico, arrecadacaoPorServico.getOrDefault(nomeServico, 0.0) + preco);
  }


  public void incrementarClientesAtendidos() {
    totalClientesAtendidos++;
  }


  public void gerarRelatorio() {
    System.out.println("Relatório de Serviços Realizados:");
    for (Map.Entry<String, Double> entry : arrecadacaoPorServico.entrySet()) {
      System.out.println("Serviço: " + entry.getKey() + ", Total Arrecadado: R$" + entry.getValue());
    }
    System.out.println("Total de Clientes Atendidos: " + totalClientesAtendidos);
  }
}
