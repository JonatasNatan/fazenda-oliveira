package animais;

public class Porco implements Animal {
  private String id;
  private int idade;
  private float pesoEmKg;
  private float pesoLimiteParaAbate = 100;
  private float ganhoDePeso = 5;
  private float precoQuilo = 9;

  public Porco(String id, int idade, float pesoEmKg) {
    this.id = id;
    this.idade = idade;
    this.pesoEmKg = pesoEmKg;
  }

  public String getId() {
    return id;
  }

  public int getIdade() {
    return idade;
  }

  public float getPesoEmKg() {
    return pesoEmKg;
  }

  public float getPesoLimiteParaAbate() {
    return pesoLimiteParaAbate;
  }

  public float getGanhoDePeso() {
    return ganhoDePeso;
  }

  public float getPrecoQuilo() {
    return precoQuilo;
  }

  @Override
  public void alimentar() {
    this.pesoEmKg += ganhoDePeso;
    System.out.printf("Animal alimentado! Seu peso subiu em %.2f kgs\n", ganhoDePeso);
  }

  @Override
  public void emitirSom() {
    System.out.println("oinc oinc, iiihhh\n");
  }

  @Override
  public boolean estaProntoParaAbate() {
    if (pesoEmKg >= pesoLimiteParaAbate) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void exibirEstado() {
    if (estaProntoParaAbate()) {
      System.out.printf("Este animal está pronto para ser vendido.\n");
    } else {
      System.out.println("Animal ainda não atingiu seu peso para venda.\n");
    }
  }

  @Override
  public float converterPesoArroba() {
    return pesoEmKg / 15;
  }

  public float precoDeVenda() {
    return precoQuilo * pesoEmKg;
  };

}
