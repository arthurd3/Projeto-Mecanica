package menus;

import mecanica.mecanico.MecanicoManager;

import java.util.Scanner;

public class MenuMecanico {
    private final MecanicoManager mecanicoManager;
    private Scanner scanner = new Scanner(System.in);

    public MenuMecanico(MecanicoManager mecanicoManager) {
        this.mecanicoManager = mecanicoManager;
    }

    public void menuMecanico() {
        while (true) {
            System.out.println("\n--- Área do Mecanico ---");
            System.out.println("1. Cadastrar Mecanico");
            System.out.println("2. Atualizar Mecanico");
            System.out.println("3. Deletar Mecanico");
            System.out.println("4. Listar Mecanicos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> mecanicoManager.cadastrarMecanico();
                case 2 -> mecanicoManager.atualizarMecanico();
                case 3 -> mecanicoManager.deletarMecanico();
                case 4 -> mecanicoManager.listarMecanicos();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida na Área Mecanico.");
            }
        }
    }
}
