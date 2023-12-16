package funcionarios;

public class Tratador implements Funcionario {
  private String nome;
  private int idade;
  private String cpf;
  private float salario = Funcionario.salarioBase;
  private float percentualPeloAbate = 0.1f;

  public Tratador(String nome, int idade, String cpf) {
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public int getIdade() {
    return idade;
  }

  public String getCpf() {
    return cpf;
  }

  public float getSalario() {
    return salario;
  }

  public float getPercentualPeloAbate() {
    return percentualPeloAbate;
  }

  public void setSalario(float adicional) {
    this.salario += adicional;
  }

  @Override
  public void exibirEstado() {

  }

}
