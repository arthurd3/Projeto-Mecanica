import java.util.ArrayList;
import java.util.List;

public class AgendamentoManager {
  private List<Agendamento> listaAgendamentos = new ArrayList<>();
  private int proximoId = 1;
  private BoxManager boxManager;

  public AgendamentoManager(BoxManager boxManager) {
    this.boxManager = boxManager;
  }

  // Realizar um novo agendamento
  public void agendar(Cliente cliente, Servico servico, Mecanico mecanico, Box box, String horario) {
    // Verificar se o box está disponível
    if (box.isOcupado()) {
      System.out.println("Box " + box.getId() + " já está ocupado.");
      return;
    }

    // Criar o agendamento
    Agendamento agendamento = new Agendamento(proximoId++, cliente, servico, mecanico, box, horario);
    listaAgendamentos.add(agendamento);

    // Atualizar o status do box para ocupado
    box.setOcupado(true);

    // Remover o horário disponível do box
    boxManager.removerHorarioDisponivel(box.getId(), horario);

    System.out.println("Agendamento realizado: " + agendamento);
  }

  // Listar todos os agendamentos
  public void listarAgendamentos() {
    if (listaAgendamentos.isEmpty()) {
      System.out.println("Nenhum agendamento realizado.");
    } else {
      System.out.println("Agendamentos realizados:");
      for (Agendamento agendamento : listaAgendamentos) {
        System.out.println(agendamento);
      }
    }
  }
}