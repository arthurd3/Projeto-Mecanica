package mecanica.mecanico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MecanicoManager {
  private List<Mecanico> listaMecanicos = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public void cadastrarMecanico() {
    System.out.println("Cadastrando Mecanico :\n");

    System.out.println("Digite o nome do Mecanico: ");
    var nomeMecanico = scanner.nextLine();

    Mecanico mecanico = new Mecanico(nomeMecanico);

    listaMecanicos.add(mecanico);
    System.out.println("Mecânico cadastrado: " + mecanico);
  }

  public void atualizarMecanico() {
    System.out.println("Atualizando Mecanico :\n");

    System.out.println("Digite o Id do Mecanico: ");
    var idMecanico = scanner.nextInt();

    Mecanico mecanico = buscarMecanicoPorId(idMecanico);

    if (mecanico == null) {
      System.out.println("Mecânico com ID " +idMecanico + " não encontrado.");
    }

    System.out.println("Digite o novo nome do Mecanico: ");
    var nomeMecanico = scanner.next();

    mecanico.setNome(nomeMecanico);



    System.out.println("Mecânico atualizado: " + mecanico);
  }


  public void deletarMecanico() {

    System.out.println("Digite o ID do Mecanico: ");
    var mecanicoId = scanner.nextInt();


    Mecanico mecanico = buscarMecanicoPorId(mecanicoId);

    if (mecanico == null) {
      System.out.println("Mecânico com ID " + mecanicoId + " não encontrado.");
    }

    listaMecanicos.remove(mecanico);
    System.out.println("Mecânico deletado: " + mecanico);


  }


  public Mecanico buscarMecanicoPorId(int id) {
    for (Mecanico mecanico : listaMecanicos) {
      if (mecanico.getId() == id) {
        return mecanico;
      }
    }
    return null;
  }


  public void listarMecanicos() {
    if (listaMecanicos.isEmpty()) {
      System.out.println("Mecânicos cadastrados:");
      for (Mecanico mecanico : listaMecanicos) {
        System.out.println(mecanico);
      }

    }
    System.out.println("Nenhum mecânico cadastrado.");
  }
}
