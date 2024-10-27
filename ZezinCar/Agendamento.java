public class Agendamento {
  private int id;
  private Cliente cliente;
  private Servico servico;
  private Mecanico mecanico;
  private Box box;
  private String horario;

  // Construtor
  public Agendamento(int id, Cliente cliente, Servico servico, Mecanico mecanico, Box box, String horario) {
    this.id = id;
    this.cliente = cliente;
    this.servico = servico;
    this.mecanico = mecanico;
    this.box = box;
    this.horario = horario;
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Servico getServico() {
    return servico;
  }

  public Mecanico getMecanico() {
    return mecanico;
  }

  public Box getBox() {
    return box;
  }

  public String getHorario() {
    return horario;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Cliente: " + cliente.getNome() + ", Serviço: " + servico.getNome() + ", Mecânico: "
        + mecanico.getNome() + ", Box: " + box.getId() + ", Horário: " + horario;
  }
}
