package mecanica.pecas;

public class Pecas {
    private static int contadorId = 0;  
    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public Pecas(String nome, double preco, int quantidade) {
        this.id = ++contadorId; 
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
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
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}
