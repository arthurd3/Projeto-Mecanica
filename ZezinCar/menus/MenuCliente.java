package menus;

import cliente.ClienteManager;

import java.util.Scanner;

public class MenuCliente {
    private final Scanner scanner = new Scanner(System.in);
    private final ClienteManager clienteManager;

    public MenuCliente(ClienteManager clienteManager) {
        this.clienteManager = clienteManager;
    }

    public void menuCliente() {
        while (true) {
            System.out.println("\n--- Área do Cliente ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Deletar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> clienteManager.cadastrarCliente();
                case 2 -> clienteManager.atualizarCliente();
                case 3 -> clienteManager.deletarCliente();
                case 4 -> clienteManager.listarClientes();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida na Área Cliente.");
            }
        }
    }

}
