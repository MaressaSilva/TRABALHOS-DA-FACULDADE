package Bolão;
import java.util.ArrayList;

public class Aposta {
    private ArrayList<Integer> numeros;
    private Jogador organizador;
    private ArrayList<Jogador> jogadores;
    
    public Aposta(){
        this.numeros  = new ArrayList<Integer>();
        this.jogadores = new ArrayList<Jogador>();
    }

    public boolean vencedora( ArrayList<Integer> sorteados){
        int i=0;
        for(Integer num: numeros){
            if(sorteados.contains(num)) i+=1;
        } 
        if(i==6) return true;
        else return false;
    }

    public void listarVencedores( double premio) {

        System.out.println("\n**** BILHETE VENCEDOR!!!*****\n");
        double premioJogador = (premio-(premio*0.1))/(this.jogadores.size());

        this.organizador.listarDados();
        System.out.println("\nPremio: " + (premio*0.1));
        System.out.println("\n**JOGADORES**");
        for(Jogador jogador: this.jogadores){
            jogador.listarDados();
            System.out.println("Premio: " + premioJogador);
        }                                      
    }

    public void inserirNumeros() {
        int numJog,i = 0,num;
        System.out.print("Insira a quandidade de números que vão ser apostados: ");
        numJog = Leitor.lerInteiro();
        while(numJog<6 || numJog>15){
            System.out.println("Quantidade precisa estar entre 6 e 15!");
            System.out.print("Insira a quandidade de números que vão ser apostados: ");
            numJog = Leitor.lerInteiro();
        }
        while(this.numeros.size()<numJog){
            System.out.print(i+1 + "° número:");
            num = Leitor.lerInteiro();
            while(!validarNum(num,this.numeros)) {
                System.out.print(i+1 + "° número:");
                num = Leitor.lerInteiro();
            } 
            i+=1;
            (this.numeros).add(num);
        }
      System.out.println("Números Inseridos...");
    }

    protected ArrayList<Integer> getNumeros(){
        return this.numeros;
    }
    
    public static boolean validarNum(int num, ArrayList<Integer> numeros){
       if(numeros.contains(num)){
        System.out.println("Esse número já foi inserido");
        return false;
       }
       if(num<1 || num>60){
        System.out.println("Digite um número entre 1 e 60");
        return false;
       }
       return true;
    }

    public void inserirOrganizador(ArrayList<Jogador> jogadoresCadastrados){
        String cpf;
        listarJogadores(jogadoresCadastrados);
        System.out.print("Digite o CPf do organizador: "); 
        cpf = Leitor.lerPalavra();
        this.organizador = buscarJogador(jogadoresCadastrados, cpf);
        if(this.organizador == null) this.organizador = getprimeiroJogador(jogadoresCadastrados);
       this.jogadores.add(organizador);
       System.out.println("Organizador Adicionado...");
    }

    public void inserirJogadores(ArrayList<Jogador>jogadoresCadastrados){ //TEM QUE LISTAR OS DADOS DE TODOS JOGADORES A CADA ESCOLHA?
        int i=1;
        Jogador jogador = null;
        System.out.print("N° de jogadores do bilhete, além do organizador: ");
        int quant = Leitor.lerInteiro();
        if(quant>0){ // MAIOR QUE 1 OU 2?
            listarJogadores(jogadoresCadastrados);
            while(i<=quant){
                System.out.print("\nDigite o CPF do jogador " + i + ": ");
                String cpfJogador = Leitor.lerPalavra();
                jogador = buscarJogador(jogadoresCadastrados, cpfJogador);
                i++;
                if(jogador == null)  jogador = getprimeiroJogador(jogadoresCadastrados);
                this.jogadores.add(jogador);
            }
            
        }
    }

    public Jogador getprimeiroJogador(ArrayList<Jogador>jogadoresCadastrados){
        System.out.println("-> Esse CPF é inválido.\nO jogador "+ jogadoresCadastrados.get(0).nome + " foi adicionado no lugar.");
        return jogadoresCadastrados.get(0);
    }
 
    public void listarJogadores(ArrayList<Jogador>jogadoresCadastrados){
        System.out.println("\n** LISTA DE JOGADORES");
        for(Jogador jogador: jogadoresCadastrados){
            jogador.listarDados();
        }
    }
   
    public static Jogador buscarJogador(ArrayList<Jogador>jogadoresCadastrados, String cpf){
        for( Jogador jogador: jogadoresCadastrados){
            if(jogador.cpf.equals(cpf)){
                return jogador;
            }
        }
        return null;
    }
}