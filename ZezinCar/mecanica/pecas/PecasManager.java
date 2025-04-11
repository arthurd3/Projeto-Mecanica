package mecanica.pecas;

import java.util.ArrayList;
import java.util.Scanner;

public class PecasManager {
    private ArrayList<Pecas> pecasList;
    private Scanner scanner = new Scanner(System.in);

    public PecasManager() {
        pecasList = new ArrayList<>();
    }

    
    public void adicionarPeca() {
        System.out.print("Digite o nome da peça: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço da peça: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade da peça: ");
        int quantidade = scanner.nextInt();

        Pecas novaPeca = new Pecas(nome, preco, quantidade);
        pecasList.add(novaPeca);
        System.out.println("Peça adicionada com sucesso: " + novaPeca);
    }

    
    public void deletarPeca() {
        System.out.println("Digite o ID da Peca a ser deletado: ");
        int id = scanner.nextInt();

        if(pecasList.isEmpty()){
            System.out.println("Lista Vazia");
            return;
        }

        boolean foiRemovido = pecasList.removeIf(p -> p.getId() == id);

        if(!foiRemovido){
            System.out.println("Peca nao Encontrada");
            return;
        }

        System.out.println("Peca removida com sucesso");


    }

    
    public void listarPecas() {
        if (pecasList.isEmpty()) {
            System.out.println("Não há peças cadastradas.");
            return;
        }

        System.out.println("Lista de Peças:");
        for (Pecas peca : pecasList) {
            System.out.println(peca); 
        }
    }

    
    public Pecas buscarPecaPorId(int id) {
        for (Pecas peca : pecasList) {
            if (peca.getId() == id) {
                return peca;
            }
        }
        System.out.println("Peça com ID " + id + " não encontrada.");
        return null;
    }
}
