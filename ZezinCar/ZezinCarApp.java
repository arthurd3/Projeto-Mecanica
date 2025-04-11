import cliente.Cliente;
import cliente.ClienteManager;
import mecanica.box.Box;
import mecanica.box.BoxManager;
import mecanica.mecanico.Mecanico;
import mecanica.mecanico.MecanicoManager;
import mecanica.pecas.PecasManager;
import mecanica.servicos.agendamentos.Agendamento;
import mecanica.servicos.agendamentos.AgendamentoManager;
import mecanica.servicos.gerenciamentoServicos.Servico;
import mecanica.servicos.gerenciamentoServicos.ServicoManager;
import mecanica.servicos.relatorio.RelatorioManager;
import menus.MenuCliente;
import menus.MenuMecanico;
import menus.MenuPecas;

private static ServicoManager servicoManager = new ServicoManager();
private static BoxManager boxManager = new BoxManager();
private static AgendamentoManager agendamentoManager = new AgendamentoManager(boxManager);
private static RelatorioManager relatorioManager = new RelatorioManager();
private static Scanner scanner = new Scanner(System.in);

private static MenuPecas menuPecas = new MenuPecas(new PecasManager());
private static MenuCliente menuCliente = new MenuCliente(new ClienteManager());
private static MenuMecanico menuMecanico = new MenuMecanico(new MecanicoManager());

public static void main(String[] args) {
  while (true) {
    System.out.println("\n--- ZezinCar Sistema Mecanica ---\n");
    System.out.println("1. Area Serviço");
    System.out.println("2. Área Mecânico");
    System.out.println("3. Área Cliente");
    System.out.println("4. Cadastrar Box");
    System.out.println("5. Realizar Agendamento");
    System.out.println("6. Consultar Disponibilidade de Boxes");
    System.out.println("7. Gerar Relatórios");
    System.out.println("8. Área Peças");
    System.out.println("0. Sair\n");
    System.out.print("Escolha uma opção: ");

    int opcao = scanner.nextInt();

    switch (opcao) {
      case 1 -> servicoManager.cadastrarServico();
      case 2 -> menuMecanico.menuMecanico();
      case 3 -> menuCliente.menuCliente();
      case 4 -> boxManager.adicionarBox();
      //case 5 -> realizarAgendamento();
      case 6 -> boxManager.listarBoxes();
      case 7 -> relatorioManager.gerarRelatorio();
      case 8 -> menuPecas.menuPecas();
      case 0 -> {
        System.out.println("Saindo do sistema...");
        scanner.close();
        System.exit(0);
      }
      default -> System.out.println("Opção inválida. Tente novamente.");
    }
  }
}



