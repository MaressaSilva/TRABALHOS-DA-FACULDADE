package Bolão;

public class Pessoa{
    protected String nome;
    protected String cpf;

    public Pessoa(){

        System.out.printf("Digite o nome: ");
        this.nome = Leitor.lerLinha();

        System.out.printf("Digite o cpf: ");
        this.cpf = Leitor.lerPalavra();  //  MELHORARA LEITURA DO CPF
        //this.pessoa.close();          SE EU FECHAR O SCANNER AQUI DA ERRO
    }
    
    public void listarDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Cpf: " + this.cpf);

    } 
}
