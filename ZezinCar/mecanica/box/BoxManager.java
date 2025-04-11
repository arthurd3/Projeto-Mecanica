package mecanica.box;

import java.util.ArrayList;
import java.util.List;

public class BoxManager {
  private List<Box> listaBoxes = new ArrayList<>();
  private int proximoId = 1;


  public void adicionarBox() {
    Box box = new Box(proximoId++);

    for (int hour = 8; hour <= 18; hour++) {
      String timeSlot = String.format("%02d:00", hour);
      box.getHorariosDisponiveis().add(timeSlot);
    }
    listaBoxes.add(box);
    System.out.println("mecanica.box.Box cadastrado: " + box);
  }


  public void atualizarStatusBox(int id, boolean ocupado) {
    Box box = buscarBoxPorId(id);
    if (box != null) {
      box.setOcupado(ocupado);
      System.out.println("Status do box atualizado: " + box);
    } else {
      System.out.println("mecanica.box.Box com ID " + id + " não encontrado.");
    }
  }


  public void removerHorarioDisponivel(int id, String horario) {
    Box box = buscarBoxPorId(id);
    if (box != null) {
      box.getHorariosDisponiveis().remove(horario);
      System.out.println("Horário " + horario + " removido do box " + id);
    } else {
      System.out.println("mecanica.box.Box com ID " + id + " não encontrado.");
    }
  }


  public Box buscarBoxPorId(int id) {
    for (Box box : listaBoxes) {
      if (box.getId() == id) {
        return box;
      }
    }
    return null;
  }

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