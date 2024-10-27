public class RelatorioManager {
  private Relatorio relatorio;

  public RelatorioManager() {
    this.relatorio = new Relatorio();
  }

  // ADICIONA UM AGENDAMENTO AO RELATORIO
  public void adicionarAgendamento(Agendamento agendamento) {
    relatorio.adicionarServico(agendamento.getServico().getNome(), agendamento.getServico().getPreco());
    relatorio.incrementarClientesAtendidos();
  }

  // GERA O RELATORIO
  public void gerarRelatorio() {
    relatorio.gerarRelatorio();
  }
}
