package mecanica.servicos.relatorio;

import mecanica.servicos.agendamentos.Agendamento;

public class RelatorioManager {
  private Relatorio relatorio;

  public RelatorioManager() {
    this.relatorio = new Relatorio();
  }

  public void adicionarAgendamento(Agendamento agendamento) {
    relatorio.adicionarServico(agendamento.getServico().getNome(), agendamento.getServico().getPreco());
    relatorio.incrementarClientesAtendidos();
  }


  public void gerarRelatorio() {
    relatorio.gerarRelatorio();
  }
}
