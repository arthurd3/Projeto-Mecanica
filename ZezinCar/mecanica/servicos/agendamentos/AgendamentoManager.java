package mecanica.servicos.agendamentos;

import cliente.Cliente;
import mecanica.box.Box;
import mecanica.box.BoxManager;
import mecanica.mecanico.Mecanico;
import mecanica.servicos.gerenciamentoServicos.Servico;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoManager {
  private List<Agendamento> listaAgendamentos = new ArrayList<>();
  private int proximoId = 1;
  private BoxManager boxManager;

  public AgendamentoManager(BoxManager boxManager) {
    this.boxManager = boxManager;
  }


  public void agendar(Cliente cliente, Servico servico, Mecanico mecanico, Box box, String horario) {

    if (box.isOcupado()) {
      System.out.println("mecanica.box.Box " + box.getId() + " já está ocupado.");
      return;
    }

    Agendamento agendamento = new Agendamento(proximoId++, cliente, servico, mecanico, box, horario);
    listaAgendamentos.add(agendamento);

    box.setOcupado(true);

    boxManager.removerHorarioDisponivel(box.getId(), horario);

    System.out.println("mecanica.servicos.agendamentos.Agendamento realizado: " + agendamento);
  }


  public void listarAgendamentos() {
    if (listaAgendamentos.isEmpty()) {
      System.out.println("Mecânicos cadastrados:");
      for (Agendamento agendamento : listaAgendamentos) {
        System.out.println(agendamento);
      }

    }
    System.out.println("Nenhum agendamento cadastrado.");
  }
}




