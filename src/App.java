import animais.Gado;
import animais.Porco;
import animais.VacaLeiteira;
import fazenda.Fazenda;
import funcionarios.ExtratorLeite;
import funcionarios.Gerente;
import funcionarios.Tratador;

public class App {
    public static void main(String[] args) throws Exception {
        Fazenda fazendaOliveira = new Fazenda("Fazenda Oliveira", 15000, "Solânea", "Paraíba");

        ExtratorLeite gabriel = new ExtratorLeite("Gabriel", 22, "0515423");
        Tratador daniel = new Tratador("Daniel", 23, "0324135");
        Gerente natan = new Gerente("Natan", 21, "2635185");

        Gado gado1 = new Gado("2651621", 2, 356);
        Gado gado2 = new Gado("123456", 2, 320);
        Gado gado3 = new Gado("789012", 4, 500);
        Gado gado4 = new Gado("345678", 3, 420);
        Gado gado5 = new Gado("901234", 2, 330);

        VacaLeiteira vacaLeiteira1 = new VacaLeiteira("2321654", 2, 195);
        VacaLeiteira vacaLeiteira2 = new VacaLeiteira("654321", 4, 250);
        VacaLeiteira vacaLeiteira3 = new VacaLeiteira("210987", 3, 180);
        VacaLeiteira vacaLeiteira4 = new VacaLeiteira("876543", 4, 260);
        VacaLeiteira vacaLeiteira5 = new VacaLeiteira("321098", 3, 190);

        Porco porco1 = new Porco("1489636", 1, 56);
        Porco porco2 = new Porco("456789", 2, 70);
        Porco porco3 = new Porco("012345", 1, 55);
        Porco porco4 = new Porco("678901", 2, 75);
        Porco porco5 = new Porco("234567", 1, 60);

        fazendaOliveira.adicionarAnimal(gado1);
        gado1.alimentar();
        gado1.emitirSom();
        fazendaOliveira.adicionarAnimal(gado2);
        fazendaOliveira.adicionarAnimal(gado3);
        fazendaOliveira.adicionarAnimal(gado4);
        fazendaOliveira.adicionarAnimal(gado5);

        fazendaOliveira.adicionarAnimal(vacaLeiteira1);
        fazendaOliveira.adicionarAnimal(vacaLeiteira2);
        fazendaOliveira.adicionarAnimal(vacaLeiteira3);
        vacaLeiteira3.alimentar();
        vacaLeiteira3.emitirSom();
        fazendaOliveira.adicionarAnimal(vacaLeiteira4);
        fazendaOliveira.adicionarAnimal(vacaLeiteira5);

        fazendaOliveira.adicionarAnimal(porco1);
        porco1.alimentar();
        porco1.emitirSom();
        porco1.exibirEstado();
        fazendaOliveira.adicionarAnimal(porco2);
        fazendaOliveira.adicionarAnimal(porco3);
        fazendaOliveira.adicionarAnimal(porco4);
        fazendaOliveira.adicionarAnimal(porco5);

        fazendaOliveira.adicionarFuncionario(gabriel);
        fazendaOliveira.adicionarFuncionario(daniel);
        fazendaOliveira.adicionarFuncionario(natan);

        fazendaOliveira.calcularSalarioFuncionarios();
        fazendaOliveira.extrairLeite(gabriel, vacaLeiteira5);
        fazendaOliveira.extrairLeite(gabriel, vacaLeiteira3);
        fazendaOliveira.venderAnimal(daniel, porco5);
        fazendaOliveira.venderAnimal(daniel, porco3);
        fazendaOliveira.venderAnimal(daniel, porco2);
        fazendaOliveira.venderAnimal(daniel, gado2);
        fazendaOliveira.venderAnimal(daniel, gado1);
        fazendaOliveira.venderAnimal(daniel, gado3);
        fazendaOliveira.venderAnimal(daniel, gado5);
        fazendaOliveira.calcularSalarioFuncionarios();
        fazendaOliveira.obterInformacoesAnimais();
        fazendaOliveira.obterInformacoesFuncionarios();
        System.out.println("Preço de animal por abate: R$" + fazendaOliveira.obterSomatorioPrecoAnimaisAbate());
        fazendaOliveira.situacaoFinanceira();
        System.out.println("Receita da fazenda: R$" + fazendaOliveira.getReceitaDaFazenda());
        System.out.println("Valor total dos salarios: R$" + fazendaOliveira.getValorTotalSalarios());
        fazendaOliveira.registrarVendaAnimais();
        fazendaOliveira.registrarVendaLeite();
        fazendaOliveira.gerarRelatorio();
    }
}
