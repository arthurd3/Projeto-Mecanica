package menus;

import mecanica.pecas.PecasManager;

import java.util.Scanner;

public class MenuPecas {

    private Scanner scanner = new Scanner(System.in);
    private final PecasManager pecasManager;

    public MenuPecas(PecasManager pecasManager) {
        this.pecasManager = pecasManager;
    }


    public void menuPecas() {
        while (true) {
            System.out.println("\n--- Área de Peças ---");
            System.out.println("1. Ver Peças");
            System.out.println("2. Adicionar Peças");
            System.out.println("3. Deletar Peças");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> pecasManager.listarPecas();
                case 2 -> pecasManager.adicionarPeca();
                case 3 -> pecasManager.deletarPeca();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida na Área de Peças.");
            }
        }
    }
}
