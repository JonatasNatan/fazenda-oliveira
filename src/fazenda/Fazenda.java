package fazenda;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animais.Animal;
import animais.Gado;
import animais.VacaLeiteira;
import funcionarios.ExtratorLeite;
import funcionarios.Funcionario;
import funcionarios.Tratador;

public class Fazenda implements InterfaceFazenda {

  private String nome;
  private int areaEmMetroQuadrado;
  private String cidade;
  private String estado;
  private List<Funcionario> funcionarios = new ArrayList<>();
  private List<Animal> animais = new ArrayList<>();
  private float precoTotalAnimaisAbate = 0;
  private float receitaDaFazenda = 0;
  private float valorTotalSalarios = 0;
  private float saldoAtual = 0;
  private float vendasAnimais = 0;
  private float vendasLeite = 0;

  private Random random = new Random();

  public Fazenda(String nome, int areaEmMetroQuadrado, String cidade, String estado) {
    this.nome = nome;
    this.areaEmMetroQuadrado = areaEmMetroQuadrado;
    this.cidade = cidade;
    this.estado = estado;
  }

  public String getNome() {
    return nome;
  }

  public float getValorTotalSalarios() {
    return valorTotalSalarios;
  }

  public int getAreaEmMetroQuadrado() {
    return areaEmMetroQuadrado;
  }

  public float getReceitaDaFazenda() {
    return receitaDaFazenda;
  }

  public String getCidade() {
    return cidade;
  }

  public String getEstado() {
    return estado;
  }

  @Override
  public void adicionarFuncionario(Funcionario funcionario) {
    this.funcionarios.add(funcionario);
  }

  @Override
  public void removerFuncionario(Funcionario funcionario) {
    this.funcionarios.remove(funcionario);
  }

  @Override
  public void adicionarAnimal(Animal animal) {
    this.animais.add(animal);
  }

  @Override
  public void removerAnimal(Animal animal) {
    this.animais.remove(animal);
  }

  @Override
  public void venderAnimal(Tratador tratador, Animal animal) {
    // calculamos o valor adicional para o salario do tratador
    float valorAdicionalParaTratador = animal.precoDeVenda() * tratador.getPercentualPeloAbate();
    // adicionamos esse valor ao seu salário
    tratador.setSalario(valorAdicionalParaTratador);
    // adicionamos o valor da venda do animal na receita da fazenda
    this.receitaDaFazenda += animal.precoDeVenda();
    this.vendasAnimais += animal.precoDeVenda();
    // removemos o animal da fazenda
    this.animais.remove(animal);
  }

  @Override
  public void extrairLeite(ExtratorLeite extrator, VacaLeiteira vaca) {
    // gerar valor aleatorio de leite extraído entre 5 e 10 litros
    int qtdLeiteExtraído = random.nextInt(6) + 5;
    // adicionar litros de leite extraído ao funcionário que extraiu seu leite
    extrator.setLitrosLeiteExtraido(qtdLeiteExtraído);
    // calculamos o valor que será adicionado ao salario desse extrator após extrair
    // o leite da vaca
    float valorAdicionalParaExtrator = (qtdLeiteExtraído * extrator.getPercentualPelaExtracao()
        * vaca.getPrecoLitroLeite());
    // adicionamos esse valor para o extrator
    extrator.setSalario(valorAdicionalParaExtrator);

    // valor gerado através dessa extração é adicionado à receita da fazenda
    this.receitaDaFazenda += qtdLeiteExtraído * vaca.getPrecoLitroLeite();
    this.vendasLeite +=  qtdLeiteExtraído * vaca.getPrecoLitroLeite();
  }

  @Override
  public void obterInformacoesAnimais() {
    int qtdGados = 0;
    int qtdVacas = 0;
    int qtdPorcos = 0;
    for (Animal animal : animais) {
      if (animal instanceof Gado) {
        qtdGados += 1;
      } else if (animal instanceof VacaLeiteira) {
        qtdVacas += 1;
      } else {
        qtdPorcos += 1;
      }
    }
    System.out.printf("A fazenda possui %d gados, %d vacas e %d porcos\n", qtdGados, qtdVacas, qtdPorcos);
  }

  @Override
  public void obterInformacoesFuncionarios() {

    int qtdTratadores = 0;
    int qtdExtratores = 0;
    int qtdGerentes = 0;
    for (Funcionario funcionario : funcionarios) {
      if (funcionario instanceof Tratador) {
        qtdTratadores += 1;
      } else if (funcionario instanceof ExtratorLeite) {
        qtdExtratores += 1;
      } else {
        qtdGerentes += 1;
      }
    }
    System.out.printf("A fazenda possui %d tratadores, %d extratores e %d gerentes \n", qtdTratadores, qtdExtratores,
        qtdGerentes);
  }

  @Override
  public void obterPrecoEstimadoAnimal(Animal animal) {
    System.out.printf("Esse animal vale, atualmente, %f \n" + //
        "", animal.precoDeVenda());

  }

  @Override
  public float obterSomatorioPrecoAnimaisAbate() {
    for (Animal animal : animais) {
      precoTotalAnimaisAbate += animal.precoDeVenda();
    }
    return precoTotalAnimaisAbate;
  }

  @Override
  public void calcularSalarioFuncionarios() {
    for (Funcionario funcionario : funcionarios) {
      this.valorTotalSalarios += funcionario.getSalario();
    }
    System.out.printf("A folha de pagamento desse mês está em R$ %.2f \n" + //
        "", this.valorTotalSalarios);
  }

  @Override
  public void situacaoFinanceira() {
    saldoAtual = this.receitaDaFazenda - this.valorTotalSalarios;
    if (saldoAtual < 0) {
      System.out.printf("A fazenda está tendo prejuízo. Saldo atual é de R$%.2f \n" + //
          "", saldoAtual);
    } else {
      System.out.printf("A fazenda está em situação de lucro com um saldo de R$%.2f \n", saldoAtual);
    }
  }

  public void registrarVendaAnimais(){
    try(FileWriter writer = new FileWriter("registro_vendas_animais.txt", false)){
      String registro = "Valor arrecadado das vendas dos animais: R$" + this.vendasAnimais;
      writer.write(registro);
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  public void registrarVendaLeite(){
    try(FileWriter writer = new FileWriter("registro_vendas_leite.txt", false)){
      String registro = "Valor arrecadado das vendas de leite: R$" + this.vendasLeite;
      writer.write(registro);
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  public void gerarRelatorio(){
    try(FileWriter writer = new FileWriter("relatorio_animais.txt", false)){
      int qtdGados = 0;
      int qtdVacas = 0;
      int qtdPorcos = 0;
      for (Animal animal : animais) {
        if (animal instanceof Gado) {
        qtdGados += 1;
        } else if (animal instanceof VacaLeiteira) {
        qtdVacas += 1;
        } else {
        qtdPorcos += 1;
        }
      }
      String registro  = "A fazenda possui:\nGados: "+ qtdGados + "\nVacas: " + qtdVacas + "\nPorcos: " + qtdPorcos;
      writer.write(registro);
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  public void relatorioAnimais() {

  }
}
