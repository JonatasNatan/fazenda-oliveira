package funcionarios;

public class Gerente implements Funcionario {
  private String nome;
  private int idade;
  private String cpf;
  private float salario = Funcionario.salarioBase;
  private int percentualDaReceita = 5;

  public Gerente(String nome, int idade, String cpf) {
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

  public void setSalario(float adicional) {
    this.salario += adicional;
  }

  @Override
  public void exibirEstado() {

  }

}
