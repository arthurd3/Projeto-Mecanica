import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZezinCarApp {
    
  //STATIC PORQUE A APLICAÇÃO USA UMA UNICA INSTANCIA DE CADA GERENCIADOR.
  private static ServicoManager servicoManager = new ServicoManager();
  private static MecanicoManager mecanicoManager = new MecanicoManager();
  private static ClienteManager clienteManager = new ClienteManager();
  private static BoxManager boxManager = new BoxManager();
  private static AgendamentoManager agendamentoManager = new AgendamentoManager(boxManager);
  private static RelatorioManager relatorioManager = new RelatorioManager();
  private static PecasManager pecasMananger = new PecasManager();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("\n--- ZezinCar Sistema de Agendamento ---");
      System.out.println("1. Cadastrar Serviço");
      System.out.println("2. Cadastrar Mecânico");
      System.out.println("3. Area Cliente");
      System.out.println("4. Cadastrar Box");
      System.out.println("5. Realizar Agendamento");
      System.out.println("6. Consultar Disponibilidade de Boxes");
      System.out.println("7. Gerar Relatórios");
      System.out.println("8. Area Peças");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");

      int opcao = scanner.nextInt();
      scanner.nextLine(); 

      switch (opcao) {
        case 1:
          cadastrarServico();
          break;
        case 2:
          cadastrarMecanico();
          break;
        case 3:
          System.out.println("1. Cadastar Cliente");
          System.out.println("2. Atualizar Cliente");
          System.out.println("3. Deletar Cliente");
          System.out.println("0. Sair"); 
          int opcao2 = scanner.nextInt();
          scanner.nextLine();
          switch(opcao2)
          {
              case 1:
                cadastrarCliente();
                break;
              case 2:
                atualizarCliente();
                break;
              case 3:
                deletarCliente();
                break;
              case 0:
                System.out.println("Saindo do sistema...");
                scanner.close();
                System.exit(0);
                break; 
              default:
                System.out.println("Opção inválida na Área Cliente.");
                break;
          }
          break;
           
            
        case 4:
          cadastrarBox();
          break;
        case 5:
          realizarAgendamento();
          break;
        case 6:
          consultarDisponibilidade();
          break;
        case 7:
          gerarRelatorios();
          break;
        case 8:
          System.out.println("1. Ver Peças");
          System.out.println("2. Adiconar Peças");
          System.out.println("3. Deletar Peças");
          System.out.println("0. Sair"); 
          int opcao3 = scanner.nextInt();
          scanner.nextLine();
          switch(opcao3)
          {
              case 1:
                verificarPecas();
                break;
              case 2:
                deletarPecas();
                break;
              case 3:
                adicionarPecas();
                break;
              case 0:
                System.out.println("Saindo do sistema...");
                scanner.close();
                System.exit(0);
                break; 
              default:
                System.out.println("Opção inválida na Área Cliente.");
                break;
          }
          break;
        case 0:
          System.out.println("Saindo do sistema...");
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }
  
  //CADASTRAR SERVICO 
  public static void cadastrarServico() {
    System.out.print("Nome do Serviço: ");
    String nome = scanner.nextLine();

    System.out.print("Preço do Serviço: ");
    double preco = scanner.nextDouble();

    scanner.nextLine(); 

    servicoManager.cadastrarServico(nome, preco);
  }
  
  //CADASTRAR MECANICO  
  public static void cadastrarMecanico() {
    System.out.print("Nome do Mecânico: ");
    String nome = scanner.nextLine();

    List<Servico> servicos = new ArrayList<>();

    while (true) {
      System.out.print("ID do Serviço (0 para terminar): ");
      int idServico = scanner.nextInt();
      scanner.nextLine(); 

      if (idServico == 0)
        break;
      Servico servico = servicoManager.buscarServicoPorId(idServico);

      if (servico != null) {
        servicos.add(servico);
      } else {
        System.out.println("Serviço com ID " + idServico + " não encontrado.");
      }
    }

    mecanicoManager.cadastrarMecanico(nome, servicos);
  }
  
  //CADASTRAR CLIENTE  
  public static void cadastrarCliente() {
    System.out.print("Nome do Cliente: ");
    String nome = scanner.nextLine();

    System.out.print("Telefone do Cliente: ");
    String telefone = scanner.nextLine();

    clienteManager.cadastrarCliente(nome, telefone);
  }
  
  //VERIFICAR PEÇAS DISPONIVEIS
  public static void verificarPecas()
  {
      pecasMananger.listarPecas();
  }
  
  //DELETAR PEÇAS 
  public static void deletarPecas()
  {
      pecasMananger.listarPecas();
  }
  
  //ADICIONAR PEÇAS 
  public static void adicionarPecas()
  {
      pecasMananger.listarPecas();
  }
  //ATUALIZAR CLIENTE  
  public static void atualizarCliente() {
    clienteManager.listarClientes();  
    
    System.out.print("ID do Cliente para ser Atualizado: ");
    int id = scanner.nextInt();
    
    System.out.print("Novo Nome: ");
    String nome = scanner.nextLine();
    
    System.out.print("Novo Telefone: ");
    String telefone = scanner.nextLine();
    
    clienteManager.atualizarCliente(id ,nome, telefone);
  }
  
  //DELETAR CLIENTE  
  public static void deletarCliente() {
    clienteManager.listarClientes();  
    System.out.print("ID do Cliente para ser Excluido: ");
    int id = scanner.nextInt();
    
    clienteManager.deletarCliente(id);
  }
  
  //CADASTRAR BOX
  public static void cadastrarBox() {
    boxManager.adicionarBox();
  }
  
  //REALIZAR AGENDAMENTO , PARA REALIZAR UM AGENDAMENTO E NECESSARIO TER CLIENTE , MECANICO E BOX REGISTRADOS
  public static void realizarAgendamento() {
      
    System.out.print("ID do Cliente: ");
    int idCliente = scanner.nextInt();
    scanner.nextLine(); 

    Cliente cliente = clienteManager.buscarClientePorId(idCliente);

    if (cliente == null) {
      System.out.println("Cliente com ID " + idCliente + " não encontrado.");
    }

    System.out.print("ID do Serviço: ");
    int idServico = scanner.nextInt();
    scanner.nextLine(); 

    Servico servico = servicoManager.buscarServicoPorId(idServico);

    if (servico == null) {
      System.out.println("Serviço com ID " + idServico + " não encontrado.");
      return;
    }

    System.out.print("ID do Mecânico: ");
    int idMecanico = scanner.nextInt();
    scanner.nextLine(); 

    Mecanico mecanico = mecanicoManager.buscarMecanicoPorId(idMecanico);

    if (mecanico == null) {
      System.out.println("Mecânico com ID " + idMecanico + " não encontrado.");
      return;
    }

    System.out.print("ID do Box: ");
    int idBox = scanner.nextInt();
    scanner.nextLine(); 

    Box box = boxManager.buscarBoxPorId(idBox);

    if (box == null) {
      System.out.println("Box com ID " + idBox + " não encontrado.");
      return;
    }

    System.out.print("Horário (HH:MM): ");
    String horario = scanner.nextLine();

    agendamentoManager.agendar(cliente, servico, mecanico, box, horario);

    relatorioManager.adicionarAgendamento(new Agendamento(0, cliente, servico, mecanico, box, horario));
  }
  
  
  //VERIFICA DISPONIBILIDADE DAS GORAS NOS BOXES
  public static void consultarDisponibilidade() {
    boxManager.listarBoxes();
  }
  
  //GERA RELATORIOS 
  public static void gerarRelatorios() {
    relatorioManager.gerarRelatorio();
  }
}