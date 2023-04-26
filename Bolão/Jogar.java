package Bolão;

public class Jogar {
    public static void printarMenu(Bolao bolao) {
        int opcao;
        do {
            System.out.println("\n** ESCOLHA UMA OPÇÃO");
            System.out.println("1. Cadastrar jogador\n" + "2. Cadastrar aposta \n" + "3. Inserir sorteio e listar vencedores\n" + "4. Sair");

            System.out.print("Opção: ");
            opcao = Leitor.lerInteiro();

            switch (opcao) {
            case 1:
                    bolao.cadastrarJogador();
                break;
            case 2:
                    bolao.cadastrarAposta();
                break;
            case 3:
                     bolao.inserirSorteio();
                break;
            case 4:
                    System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
            }

        } while (opcao != 4);
        Leitor.fecharScanner();
    }
    
}

