import java.util.ArrayList;
import java.util.List;

public class ClienteManager {
  private List<Cliente> listaClientes = new ArrayList<>();
  private int proximoId = 1;

  // CADASTRA UM NOVO CLIENTE
  public void cadastrarCliente(String nome, String telefone) {
    Cliente cliente = new Cliente(proximoId++, nome, telefone);
    listaClientes.add(cliente);
    System.out.println("Cliente cadastrado: " + cliente);
  }

  // ATUALIZA UM CLIENTE ESCOLHIDO
  public void atualizarCliente(int id, String novoNome, String novoTelefone) {
    Cliente cliente = buscarClientePorId(id);
    if (cliente != null) {
      cliente.setNome(novoNome);
      cliente.setTelefone(novoTelefone);
      System.out.println("Cliente atualizado: " + cliente);
    } else {
      System.out.println("Cliente com ID " + id + " não encontrado.");
    }
  }

  // DELETA UM CLIENTE
  public void deletarCliente(int id) {
    Cliente cliente = buscarClientePorId(id);
    if (cliente != null) {
      listaClientes.remove(cliente);
      System.out.println("Cliente deletado: " + cliente);
    } else {
      System.out.println("Cliente com ID " + id + " não encontrado.");
    }
  }

  // BUSCA UM CLIENTE POR ID
  public Cliente buscarClientePorId(int id) {
    for (Cliente cliente : listaClientes) {
      if (cliente.getId() == id) {
        return cliente;
      }
    }
    return null;
  }

  // LISTA TODOS OS CLIENTES
  public void listarClientes() {
    if (listaClientes.isEmpty()) {
      System.out.println("Nenhum cliente cadastrado.");
    } else {
      System.out.println("Clientes cadastrados:");
      for (Cliente cliente : listaClientes) {
        System.out.println(cliente);
      }
    }
  }
}
