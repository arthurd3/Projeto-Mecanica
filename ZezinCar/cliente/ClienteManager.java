package cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteManager {
  private List<Cliente> listaClientes = new ArrayList<>();

  private Scanner scanner = new Scanner(System.in);

  public void cadastrarCliente() {
    System.out.println("Digite o nome do cliente: ");
    var nome = scanner.nextLine();

    System.out.println("Digite o nome do telefone: ");
    var telefone = scanner.nextLine();

    Cliente cliente = new Cliente(nome, telefone);
    listaClientes.add(cliente);

    System.out.println("Cliente cadastrado com Sucesso! : " + cliente);
  }


  public void atualizarCliente()  {
    System.out.println("Digite o ID do cliente: ");
    var clienteId = scanner.nextInt();

    if (buscarClientePorId(clienteId) == null)
      System.out.println("cliente.Cliente com ID " + clienteId + " não encontrado.");

    var clienteAtualizado = buscarClientePorId(clienteId);

    System.out.print("Novo Nome: ");
    clienteAtualizado.setNome(scanner.nextLine());

    System.out.print("Novo Telefone: ");
    clienteAtualizado.setTelefone(scanner.nextLine());

    listaClientes.add(clienteAtualizado);

    System.out.println("cliente.Cliente atualizado: " + clienteAtualizado);
  }


  public void deletarCliente() {

    System.out.println("Digite o ID do cliente: ");
    var clienteId = scanner.nextInt();

    if (buscarClientePorId(clienteId) == null) {
      System.out.println("Cliente com ID " + clienteId + " não encontrado.");
    }

    var cliente = buscarClientePorId(clienteId);

    listaClientes.remove(cliente);

    System.out.println("Cliente deletado: " + cliente);
  }


  public Cliente buscarClientePorId(int id) {
    for (Cliente cliente : listaClientes) {
      if (cliente.getId() == id)
        return cliente;
    }
    return null;
  }


  public void listarClientes() {
    if (!listaClientes.isEmpty()) {
      System.out.println("Clientes cadastrados:");
      for (Cliente cliente : listaClientes)
        System.out.println(cliente);
      return;
    }
    System.out.println("Nenhum cliente encontrado.");

  }
}
