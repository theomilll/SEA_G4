package br.gov.cesarschool.projetos.main;

import br.gov.cesarschool.projetos.doador.ItemDoacao;
import br.gov.cesarschool.projetos.ong.ONG;
import br.gov.cesarschool.projetos.endereco.Endereco;
import br.gov.cesarschool.projetos.doador.Doador;
import br.gov.cesarschool.projetos.necessidade.*;
import br.gov.cesarschoo.projetos.mediator.Mediator;
import br.gov.cesarschool.projetos.DAO.*;
import br.gov.cesarschool.projetos.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mediator mediator = Mediator.getInstance();
        DAO arquivoDAO = new DAO("SEA_");
        

        Doador usuario = null;
        ONG ong = null;

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Registrar Usuário");
            System.out.println("2. Registrar ONG");
            System.out.println("3. Registrar Necessidade da ONG");
            System.out.println("4. Fazer Doações");
            System.out.println("5. Entrar com CPF");
            System.out.println("6. Entrar com CNPJ");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    usuario = registrarUsuario(scanner, mediator);
                    break;
                case 2:
                    ong = registrarONG(scanner, mediator);
                    break;
                case 3:
                    if (ong != null) {
                        registrarNecessidadeONG(scanner, mediator, ong);
                    } else {
                        System.out.println("É necessário escolher uma ONG primeiro, cadastre uma ou use o CNPJ!");
                    }
                    break;
                case 4:
                    if ( ong != null) {
                        fazerDoacoes(scanner, mediator, ong, usuario);
                    } else {
                        System.out.println("Por favor, registre um usuário e uma ONG primeiro!");
                    }
                    break;
                case 5:
                	System.out.print("Insira o CPF: ");
                	String cpfComp= scanner.nextLine();
                	usuario = arquivoDAO.buscarDoadorPorCPF(cpfComp);
                     if(usuario == null) {
                    	 System.out.println("Usuário não possui cadastro");
                    	 break;
                     }
                     else {
                    	 mediator.inserirDoador(usuario);
                     }
                        
                    break;
                case 6:
                    System.out.print("Insira o CNPJ: ");
                    String cnpjComp = scanner.nextLine();
                    ong = arquivoDAO.buscarONGPorCNPJ(cnpjComp);
                    if (ong == null) {
                        System.out.println("ONG não possui cadastro");
                        break;
                    } 
 
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static Doador registrarUsuario(Scanner scanner, Mediator mediator) {
        System.out.println("Registro de Usuário");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, complemento, cep, cidade, estado, pais);

        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail do usuário: ");
        String email = scanner.nextLine();

        System.out.print("Número de telefone do usuário: ");
        String numeroTelefone = scanner.nextLine();

        System.out.print("ID do usuário: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("CPF do usuário: ");
        String cpf = scanner.nextLine();

        System.out.print("Método de pagamento do usuário: ");
        String formaPagamento = scanner.nextLine();

        Doador usuario = new Doador(nome, email, numeroTelefone, id, endereco, cpf, formaPagamento);
        mediator.inserirDoador(usuario);


        return usuario;
    }

    private static ONG registrarONG(Scanner scanner, Mediator mediator) {
        System.out.println("Registro de ONG");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();

        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Complemento: ");
        String complemento = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, complemento, cep, cidade, estado, pais);

        System.out.print("Nome da ONG: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail da ONG: ");
        String email = scanner.nextLine();

        System.out.print("Número de telefone da ONG: ");
        String numeroTelefone = scanner.nextLine();

        System.out.print("ID da ONG: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("CNPJ da ONG: ");
        String cnpj = scanner.nextLine();

        System.out.print("Descrição da ONG: ");
        String descricao = scanner.nextLine();

        System.out.print("Número de voluntários na ONG: ");
        int numVoluntarios = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        ONG ong = new ONG(nome, email, numeroTelefone, id, endereco, cnpj, descricao, numVoluntarios);
        mediator.inserirONG(ong);

        System.out.println("ONG registrada com sucesso!");
        return ong;
    }

    private static void registrarNecessidadeONG(Scanner scanner, Mediator mediator, ONG ong) {
        System.out.println("Registro de Necessidade da ONG");
        System.out.print("Nome do item de necessidade: ");
        String nomeItem = scanner.nextLine();

        System.out.print("Quantidade do item de necessidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Necessidade necessidade = new Necessidade(quantidade, nomeItem);
        ong.setNecessidade(necessidade);
        mediator.inserirNecessidade(ong, necessidade);

        System.out.println("Necessidade da ONG registrada com sucesso!");
    }

    private static void fazerDoacoes(Scanner scanner, Mediator mediator, ONG ong, Doador usuario) {
        System.out.println("Fazer Doações");
        System.out.print("Nome do item de doação: ");
        String nomeItem = scanner.nextLine();

        System.out.print("Quantidade do item de doação: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        ItemDoacao doacao = new ItemDoacao(nomeItem, quantidade);
        if(usuario == null) {
        	mediator.inserirDoacao(doacao, ong);
        }
        else {
        	mediator.inserirDoacao(doacao, ong, usuario);
        }

        
    }
}