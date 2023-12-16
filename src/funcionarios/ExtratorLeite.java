package funcionarios;

public class ExtratorLeite implements Funcionario {

  private String nome;
  private int idade;
  private String cpf;
  private float salario = Funcionario.salarioBase;
  private float percentualPelaExtracao = 0.05f;
  private int litrosLeiteExtraido = 0;

  public ExtratorLeite(String nome, int idade, String cpf) {
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

  public float getPercentualPelaExtracao() {
    return percentualPelaExtracao;
  }

  public int getLitrosLeiteExtraido() {
    return litrosLeiteExtraido;
  }

  public void setLitrosLeiteExtraido(int litrosAdicionais) {
    this.litrosLeiteExtraido += litrosAdicionais;
  }

  @Override
  public void exibirEstado() {

  }

}
