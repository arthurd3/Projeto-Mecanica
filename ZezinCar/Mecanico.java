import java.util.List;

public class Mecanico {
  private int id;
  private String nome;
  private List<Servico> servicos;

  
  public Mecanico(int id, String nome, List<Servico> servicos) {
    this.id = id;
    this.nome = nome;
    this.servicos = servicos;
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

  public List<Servico> getServicos() {
    return servicos;
  }

  public void setServicos(List<Servico> servicos) {
    this.servicos = servicos;
  }
  
  //Transforma um objeto em String  
  @Override
  public String toString() {
    return "ID: " + id + ", Nome: " + nome + ", Serviços: " + servicos;
  }
}
