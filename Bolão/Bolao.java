package Bolão;

import java.util.ArrayList;

public class Bolao {

    private ArrayList<Aposta> apostas;
    private ArrayList<Jogador> jogadores;

    public Bolao(){
        apostas = new ArrayList<Aposta>();
        jogadores = new ArrayList<Jogador>();

    }
    
    public void cadastrarJogador(){
        Jogador jogador = new Jogador();
        if((Aposta.buscarJogador(jogadores, jogador.getCpf())== null)){
            this.jogadores.add(jogador);
            System.out.println("Jogador Cadastrado...");
        }
        else{
            System.out.println("Esse CPF já está cadastrado...");
        }
        
    }

    public void cadastrarAposta(){  // PRECISA TER JOGADORES ANTES??
        Aposta aposta = new Aposta();
        if(jogadores.size()>0){
            aposta.inserirNumeros();
            aposta.inserirOrganizador(jogadores);
            aposta.inserirJogadores(jogadores);
            this.apostas.add(aposta);
        }else{
            System.out.println("\n NÃO HÁ JOGADORES SUFICIENTE CADASTRADOS!");
        }
    }

    private ArrayList<Aposta> vencedoras( ArrayList<Integer> sorteados){
        ArrayList<Aposta> ganhadoras = new ArrayList<Aposta>();
        for( Aposta aposta: this.apostas){
            if(aposta.vencedora(sorteados)){
                ganhadoras.add(aposta);
            }
        }
        return ganhadoras;
    }

    public void inserirSorteio(){
        double premio, premioBilhete;
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Aposta> vencedoras = new ArrayList<Aposta>();
        int num = 0;

        System.out.println("\nDIGITE OS NÚMEROS SORTEDOS");
        for(int i=1;i<=6;i++){
            System.out.print( + i + "° número: ");
            num = Leitor.lerInteiro();
           while(!Aposta.validarNum(num, numeros)){
                System.out.print(i+1 + "° número:");
                num = Leitor.lerInteiro();
           }
            numeros.add(num);
        }
        System.out.print("Valor do prémio: ");
        premio = Leitor.lerDouble();   
        vencedoras = vencedoras(numeros);
        premioBilhete = premio/(vencedoras.size());
        if(vencedoras.size()==0){
            System.out.println(" Não há aposta vencedora");
            return;
        }else{
            for( Aposta aposta: vencedoras){
                aposta.listarVencedores(premioBilhete);
            }
        }
        
    }
    /*public static boolean validarNum(int num, ArrayList<Integer> numeross){
    public boolean validarNum(int num, ArrayList<Integer> numeross){
        if(numeross.contains(num)){
         System.out.println("Esse número já foi inserido");
         return false;
        }
        if(num<1 || num>60){
         System.out.println("Digite um número entre 1 e 60");
         return false;
        }
        return true;
     }*/
}