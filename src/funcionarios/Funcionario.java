package funcionarios;

public interface Funcionario {
  static float salarioBase = 1200;

  public void exibirEstado();

  public void setSalario(float adicional);

  public float getSalario();
}
