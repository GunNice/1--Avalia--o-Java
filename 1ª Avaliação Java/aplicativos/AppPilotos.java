package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import classes.Pessoa;
import classes.Piloto;
import classes.Aeronave;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        String consultaCpf;

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                Piloto piloto= new Piloto();
                System.out.println("Insira o Nome: ");
                piloto.setNome(in.next());
                System.out.println("Insira o CPF: ");
                piloto.setCpf(in.next());
                System.out.println("Insira o Brevê: ");
                piloto.setBreve(in.next());
                pilotos [qtdCadastrados] = piloto;
                qtdCadastrados++;


                System.out.println("\nPiloto cadastrado com sucesso.");

                in.nextLine();
                voltarMenu(in);
                
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if(pilotos[0] != null){
                    for (Pessoa pessoa : pilotos) {
                        if(pessoa != null){
                            System.out.println(pessoa);
                        } 
                    }

                    // Exiba os pilotos aqui
                }
                else if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    in.nextLine();
                    voltarMenu(in);
                    continue;
                }

                

                voltarMenu(in);
            } else if (opcao == 3) {
                Boolean localizado = false;
                    System.out.println("Informe CPF do Piloto:");
                    consultaCpf = in.next();
                    for (Pessoa pessoa : pilotos) {
                        if(pessoa != null && consultaCpf .equals(pessoa.getCpf())){
                            System.out.println(pessoa);
                            localizado = true;
                            break;
                        
                        }
                    }
                        if (!localizado) {
                            System.out.println("O CPF de Nº: " + consultaCpf + " não foi encontrado!");
                    }


            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                 if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    
                    voltarMenu(in);
                    continue;
                }
                System.out.println("Informe o CPF do Piloto:");
                consultaCpf = in.next();
                for (Pessoa pessoa : pilotos) {
                    if(pessoa != null && consultaCpf .equals(pessoa.getCpf())){
                        System.out.println("Informe a Modelo da Aeronave:");
                        Aeronave nave = new Aeronave();
                        nave.setModelo(in.next());
                        System.out.println("Informe o Nº de série da Aeronave:");
                        
                        nave.setNumeroSerie(in.next());
                        pessoa.setNave(nave);
                    }
                }
               

                //Solicite ao usuário o piloto
                //Crie a aeronave vinculando-a ao piloto
                System.out.println("\nAeronave cadastrada com sucesso.");
                //Exiba os dados da aeronave
                in.nextLine();
                voltarMenu(in);
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}