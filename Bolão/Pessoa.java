package Bolão;

public class Pessoa{
    protected String nome;
    protected String cpf;

    public Pessoa(){
        
        System.out.print("\nDigite o nome: ");
        this.nome = Leitor.lerLinha();

        System.out.print("Digite o cpf: ");
        this.cpf = Leitor.lerPalavra();
    }
    
    public void listarDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Cpf: " + this.cpf);

    } 
}
