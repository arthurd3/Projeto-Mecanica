import java.util.ArrayList;
import java.util.List;

public class BoxManager {
  private List<Box> listaBoxes = new ArrayList<>();
  private int proximoId = 1;

  // ADICIONA UM NOVO BOX
  public void adicionarBox() {
    Box box = new Box(proximoId++);
    // DEFINE HORARIOS
    for (int hour = 8; hour <= 18; hour++) {
      String timeSlot = String.format("%02d:00", hour);
      box.getHorariosDisponiveis().add(timeSlot);
    }
    listaBoxes.add(box);
    System.out.println("Box cadastrado: " + box);
  }

  // ATUALIZA O STATUS DE UM BOX
  public void atualizarStatusBox(int id, boolean ocupado) {
    Box box = buscarBoxPorId(id);
    if (box != null) {
      box.setOcupado(ocupado);
      System.out.println("Status do box atualizado: " + box);
    } else {
      System.out.println("Box com ID " + id + " não encontrado.");
    }
  }

  // REMOVE UM HORARIO DISPONIVEL DO BOX
  public void removerHorarioDisponivel(int id, String horario) {
    Box box = buscarBoxPorId(id);
    if (box != null) {
      box.getHorariosDisponiveis().remove(horario);
      System.out.println("Horário " + horario + " removido do box " + id);
    } else {
      System.out.println("Box com ID " + id + " não encontrado.");
    }
  }

  // BUSCA UM BOX POR ID
  public Box buscarBoxPorId(int id) {
    for (Box box : listaBoxes) {
      if (box.getId() == id) {
        return box;
      }
    }
    return null;
  }

  // LISTA TODOS OS BOXES
  public void listarBoxes() {
    if (listaBoxes.isEmpty()) {
      System.out.println("Nenhum box cadastrado.");
    } else {
      System.out.println("Boxes cadastrados:");
      for (Box box : listaBoxes) {
        System.out.println(box);
      }
    }
  }
}