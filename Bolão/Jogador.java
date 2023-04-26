package Bolão;

public class Jogador extends Pessoa{

    protected String pix;
   
    public Jogador(){
        super();
        System.out.print("Insira o PIX: ");
        this.pix = Leitor.lerPalavra();
        //System.out.println("");
    }
    public  void listarDados(){
        super.listarDados();
        System.out.println("Pix: " + this.pix );

    }
    protected String getCpf(){
        return this.cpf;
    }

}