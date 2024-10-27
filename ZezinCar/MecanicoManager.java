import java.util.ArrayList;
import java.util.List;

public class MecanicoManager {
  private List<Mecanico> listaMecanicos = new ArrayList<>();
  private int proximoId = 1;

  // CADASTRAR MECANICO
  public void cadastrarMecanico(String nome, List<Servico> servicos) {
    Mecanico mecanico = new Mecanico(proximoId++, nome, servicos);
    listaMecanicos.add(mecanico);
    System.out.println("Mecânico cadastrado: " + mecanico);
  }

  // ATUALIZAR MECANICO EXISTENTE
  public void atualizarMecanico(int id, String novoNome, List<Servico> novosServicos) {
    Mecanico mecanico = buscarMecanicoPorId(id);
    if (mecanico != null) {
      mecanico.setNome(novoNome);
      mecanico.setServicos(novosServicos);
      System.out.println("Mecânico atualizado: " + mecanico);
    } else {
      System.out.println("Mecânico com ID " + id + " não encontrado.");
    }
  }

  // DELETAR UM MECANICO
  public void deletarMecanico(int id) {
    Mecanico mecanico = buscarMecanicoPorId(id);
    if (mecanico != null) {
      listaMecanicos.remove(mecanico);
      System.out.println("Mecânico deletado: " + mecanico);
    } else {
      System.out.println("Mecânico com ID " + id + " não encontrado.");
    }
  }

  // BUSCAR UM MECANINCO POR ID
  public Mecanico buscarMecanicoPorId(int id) {
    for (Mecanico mecanico : listaMecanicos) {
      if (mecanico.getId() == id) {
        return mecanico;
      }
    }
    return null;
  }

  // LISTAR TODOS MECANICOS EXISTENTES
  public void listarMecanicos() {
    if (listaMecanicos.isEmpty()) {
      System.out.println("Nenhum mecânico cadastrado.");
    } else {
      System.out.println("Mecânicos cadastrados:");
      for (Mecanico mecanico : listaMecanicos) {
        System.out.println(mecanico);
      }
    }
  }
}
