import java.util.ArrayList;
import java.util.List;

public class Box {
  private int id;
  private boolean ocupado;
  private List<String> horariosDisponiveis;

  public Box(int id) {
    this.id = id;
    this.ocupado = false; //O BOX COMEÇA DISPONIVEL
    this.horariosDisponiveis = new ArrayList<>();
  }


  public int getId() {
    return id;
  }

  public boolean isOcupado() {
    return ocupado;
  }

  public void setOcupado(boolean ocupado) {
    this.ocupado = ocupado;
  }

  public List<String> getHorariosDisponiveis() {
    return horariosDisponiveis;
  }

  public void setHorariosDisponiveis(List<String> horariosDisponiveis) {
    this.horariosDisponiveis = horariosDisponiveis;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Ocupado: " + (ocupado ? "Sim" : "Não") + ", Horários Disponíveis: " + horariosDisponiveis;
  }
}
