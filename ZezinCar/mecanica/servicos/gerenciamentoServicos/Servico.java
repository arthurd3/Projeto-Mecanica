package mecanica.servicos.gerenciamentoServicos;

public class Servico {
  private static int idCont = 0 ;
  private int id;
  private String nome;
  private double preco;


  public Servico( String nome, double preco) {
    this.id = ++idCont;
    this.nome = nome;
    this.preco = preco;
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

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  @Override
  public String toString() {
    return "ID: " + id + ", Nome: " + nome + ", Preço: R$" + preco;
  }
}
