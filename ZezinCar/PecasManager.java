import java.util.ArrayList;
import java.util.Scanner;

public class PecasManager {
    private ArrayList<Pecas> pecasList;
    private Scanner scanner;

    public PecasManager() {
        pecasList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    
    public void adicionarPeca() {
        System.out.print("Digite o ID da peça: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

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

    
    public void deletarPeca(int id) {
        for (int i = 0; i < pecasList.size(); i++) {
            if (pecasList.get(i).getId() == id) {
                pecasList.remove(i);
                System.out.println("Peça com ID " + id + " deletada com sucesso.");
                return;
            }
        }
        System.out.println("Peça com ID " + id + " não encontrada. Nenhuma peça foi deletada.");
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
