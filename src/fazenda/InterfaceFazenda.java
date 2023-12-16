package fazenda;

import animais.Animal;
import animais.VacaLeiteira;
import funcionarios.ExtratorLeite;
import funcionarios.Funcionario;
import funcionarios.Tratador;

public interface InterfaceFazenda {
  public void adicionarFuncionario(Funcionario funcionario);

  public void removerFuncionario(Funcionario funcionario);

  public void venderAnimal(Tratador tratador, Animal animal);

  public void adicionarAnimal(Animal animal);

  public void removerAnimal(Animal animal);

  public void extrairLeite(ExtratorLeite extrator, VacaLeiteira vaca);

  public void obterInformacoesAnimais();

  public void obterInformacoesFuncionarios();

  public void obterPrecoEstimadoAnimal(Animal animal);

  public float obterSomatorioPrecoAnimaisAbate();

  public void calcularSalarioFuncionarios();

  public void situacaoFinanceira();

  public void relatorioAnimais();
}
