package mecanica.servicos.agendamentos;

import cliente.Cliente;
import mecanica.box.Box;
import mecanica.mecanico.Mecanico;
import mecanica.servicos.gerenciamentoServicos.Servico;

public class Agendamento {
  private int id;
  private Cliente cliente;
  private Servico servico;
  private Mecanico mecanico;
  private Box box;
  private String horario;

  public Agendamento(int id, Cliente cliente, Servico servico, Mecanico mecanico, Box box, String horario) {
    this.id = id;
    this.cliente = cliente;
    this.servico = servico;
    this.mecanico = mecanico;
    this.box = box;
    this.horario = horario;
  }


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
    return "ID: " + id + ", cliente.Cliente: " + cliente.getNome() + ", Serviço: " + servico.getNome() + ", Mecânico: "
        + mecanico.getNome() + ", mecanica.box.Box: " + box.getId() + ", Horário: " + horario;
  }
}
