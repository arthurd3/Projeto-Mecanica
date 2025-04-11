package mecanica.mecanico;

public class Mecanico {
  private static int idCont = 0;
  private int id;
  private String nome;

  public Mecanico(String nome) {
    this.id = ++idCont;
    this.nome = nome;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }




  @Override
  public String toString() {
    return "ID: " + id + ", Nome: " + nome;
  }
}
