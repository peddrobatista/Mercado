package br.com.peddrobatista.view;

import br.com.peddrobatista.helper.Utils;
import br.com.peddrobatista.model.Produto;

import java.util.*;

public class Mercado {
    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<Produto>();
        carrinho = new HashMap<Produto, Integer>();
        Mercado.menu();
    }

    private static void menu() {
        System.out.println("==================================");
        System.out.println("============ Bem Vindo ===========");
        System.out.println("============= Mercado ============");
        System.out.println("==================================");
        System.out.println("Selecione a opção abaixo: ");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Comprar produto");
        System.out.println("4 - Visualizar carrinho");
        System.out.println("5 - Sair do sistema");

        int opcao = 0;

        try {
            opcao = Integer.parseInt(Mercado.teclado.nextLine());
        } catch(InputMismatchException e) {
            Mercado.menu();
        } catch(NumberFormatException f) {
            Mercado.menu();
        }

        switch (opcao) {
            case 1:
                Mercado.cadastrarProduto();
                break;
            case 2:
                Mercado.listarProdutos();
                break;
            case 3:
                Mercado.comprarProduto();
            case 4:
                Mercado.visualizarCarrinho();
                break;
            case 5:
                System.out.println("Volte Sempre!");
                Utils.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                Utils.pausar(2);
                Mercado.menu();
                break;
        }
    }
    private static void cadastrarProduto() {
        System.out.println("Cadastro de Produto");
        System.out.println("===================");

        System.out.println("Informe o nome do produto: ");
        String nome = Mercado.teclado.nextLine();

        System.out.println("Informe o preço do produto: ");
        Double preco = Mercado.teclado.nextDouble();

        Produto produto = new Produto(nome, preco);
        Mercado.produtos.add(produto);

        System.out.println("O produto " + produto.getNome() + " foi cadastrado com sucesso!");
        Utils.pausar(2);
        Mercado.menu();
    }
    private static void listarProdutos() {
        if(Mercado.produtos.size() > 0) {
            System.out.println("Listagem de produtos");

            for (Produto p: Mercado.produtos) {
                System.out.println(p);
                System.out.println();
            }
        } else {
            System.out.println("Ainda não existem produtos cadastrados!");
        }
        Utils.pausar(2);
        Mercado.menu();
    }
    private static void comprarProduto() {
        if (Mercado.produtos.size() > 0) {
            System.out.println("Informe o código do produto que deseja comprar: ");
            System.out.println();

            System.out.println("============= Produtos Disponíveis ================");
            for (Produto p: Mercado.produtos) {
                System.out.println(p); // O p imprime o toString
                System.out.println("---------------------------------");
            }

            int codigo = Integer.parseInt(Mercado.teclado.nextLine());
            boolean tem = false;
        } else {
            System.out.println("Ainda não existem produtos cadastrado no mercaado!");
            Utils.pausar(2);
            Mercado.menu();
        }
    }
    private static void visualizarCarrinho() {
        if (Mercado.produtos.size() > 0) {
            System.out.println("Produtos no Carrinho");
            for (Produto p: Mercado.carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + Mercado.carrinho.get(p));
            }
        } else {
            System.out.println("Ainda não existem produtos no carrinho! ");
        }
        Utils.pausar(2);
        Mercado.menu();
    }
}