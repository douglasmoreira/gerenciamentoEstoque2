package br.com.zup.gerenciamentoEstoque2.programaprincipal;

import java.util.Scanner;

import br.com.zup.gerenciamentoEstoque2.estoque.EstoqueProdutoAlimenticio;
import br.com.zup.gerenciamentoEstoque2.estoque.EstoqueProdutoLimpeza;
import br.com.zup.gerenciamentoEstoque2.produto.Produto;
import br.com.zup.gerenciamentoEstoque2.produto.ProdutoAlimenticio;
import br.com.zup.gerenciamentoEstoque2.produto.ProdutoLimpeza;


public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		EstoqueProdutoLimpeza estoqueProdutoLimpeza = new EstoqueProdutoLimpeza();
		EstoqueProdutoAlimenticio estoqueProdutoAlimenticio = new EstoqueProdutoAlimenticio();
		
		System.out.println("BEM VINDO AO NOSSO SISTEMA DE ESTOQUE!\n");
		
		int opcao = 0;
		
		do {
			opcao = menu(input, estoqueProdutoLimpeza, estoqueProdutoAlimenticio);		
		}while(opcao != 0);
	}

	public static int menu(Scanner input, EstoqueProdutoLimpeza estoqueProdutoLimpeza, EstoqueProdutoAlimenticio estoqueAlimenticio) {
		
		System.out.printf("%-75s %s\n","Para manipular o menu Produtos Alimenticios","digite 1:");
		System.out.printf("%-75s %s\n","Para manipular o menu Produtos de Limpeza","digite 2:");
		System.out.printf("%-75s %s\n","Para encerar o Programa","digite 0:");
		int opcao = input.nextInt();
		
		switch (opcao) {
		case 1:
			subMenuprodutoAlimenticio(input, estoqueAlimenticio);
			break;
	
		case 2:
			subMenuprodutoLimpeza(input, estoqueProdutoLimpeza);
			break;
		}
		
		return opcao;
	}
	
	public static int subMenuprodutoLimpeza(Scanner input, EstoqueProdutoLimpeza estoqueProdutoLimpeza) {
		
		int opcao = 0;
		
		do {
			
			System.out.printf("%-75s %s\n","para cadastrar produto de limpeza", "digite 1");
			System.out.printf("%-75s %s\n","Para remover produto de limpeza", "digite 2");
			System.out.printf("%-75s %s\n","Para exibir a lista de produtos", "digite 3");
			System.out.printf("%-75s %s\n","Para alterar o preço de todos os produtos", "digite 4");
			System.out.printf("%-75s %s\n","Para alterar o preço de um produto", "digite 5");
			System.out.printf("%-75s %s\n","Para consultar um produto", "digite 6");
			System.out.printf("%-75s %s\n","Para gravar a lista de produtos em um arquivo ProdutoLimpeza.txt", "digite 7");
			System.out.printf("%-75s %s\n","Para saber a quantidade de todos os produtos na lista", "digite 8");
			System.out.printf("%-75s %s\n","Para saber a media de valores", "digite 9");
			System.out.printf("%-75s %s\n","Para voltar ao menu anterior","digite 0\n");
			opcao= input.nextInt();
			
			switch (opcao) {
			case 1:
				cadastraProdutoLimpeza(input, estoqueProdutoLimpeza);
				break;
			case 2:
				removerProdutoLimpeza(input, estoqueProdutoLimpeza);
				break;
			case 3:
				listaDeProdutosLimpeza(estoqueProdutoLimpeza);
				break;
			case 4:
				alterarPrecoProdutoLimpeza(input, estoqueProdutoLimpeza);
				break;
			case 5:
				alterarPrecoDeUmProdutoLimpeza(input, estoqueProdutoLimpeza);
				break;
			case 6:
				consultaProdutoLimpeza(input, estoqueProdutoLimpeza);
				break;
			case 7:
				estoqueProdutoLimpeza.gravaListaProdutos();
				break;
			case 8:
				System.out.println("A quantidade de produtos no estoque é " + estoqueProdutoLimpeza.quantidadeProdutosEmEstoque());
				break;
			case 9:
				System.out.println("A média de valores de venda é: " + estoqueProdutoLimpeza.mediaValoresVenda());
				break;
			case 0:
				break;
			}
		} while (opcao != 0);
		
		
		return opcao;
	}
	
	public static int subMenuprodutoAlimenticio(Scanner input, EstoqueProdutoAlimenticio estoqueAlimenticio) {
	
	int opcao = 0;
	
	do {
		System.out.printf("%-75s %s\n","Para cadastrar produto de alimenticios", "digite 1");
		System.out.printf("%-75s %s\n","Para remover produto de alimenticios", "digite 2");
		System.out.printf("%-75s %s\n","Para exibir a lista de produtos", "digite 3");
		System.out.printf("%-75s %s\n","Para alterar o preço de todos os produtos", "digite 4");
		System.out.printf("%-75s %s\n","Para alterar o preço de um produto", "digite 5");
		System.out.printf("%-75s %s\n","Para consultar um produto", "digite 6");
		System.out.printf("%-75s %s\n","Para gravar a lista de produtos em um arquivo ProdutoAlimenticios.txt", "digite 7");
		System.out.printf("%-75s %s\n","Para saber a quantidade de todos os produtos na lista", "digite 8");
		System.out.printf("%-75s %s\n","Para saber a media de valores", "digite 9");
		System.out.printf("%-75s %s\n","Para voltar ao menu anterior","digite 0\n");
		opcao= input.nextInt();
		
		switch (opcao) {
		case 1:
			cadastraProdutoAlimenticio(input, estoqueAlimenticio);
			break;
		case 2:
			removerProdutoAlimenticio(input, estoqueAlimenticio);
			break;
		case 3:
			listaDeProdutosAlimenticio(estoqueAlimenticio);
			break;
		case 4:
			alterarPrecoProdutoAlimenticio(input, estoqueAlimenticio);
			break;
		case 5:
			alterarPrecoDeUmProdutoAlimenticio(input, estoqueAlimenticio);
			break;
		case 6:
			consultaProdutoAlimenticio(input, estoqueAlimenticio);
			break;
		case 7:
			estoqueAlimenticio.gravaListaProdutos();
			break;
		case 8:
			System.out.println("A quantidade de produtos no estoque é " + estoqueAlimenticio.quantidadeProdutosEmEstoque());
			break;
		case 9:
			System.out.println("A média de valores de venda é: " + estoqueAlimenticio.mediaValoresVenda());;
			break;
		case 0:
			break;
		}
	} while (opcao != 0);
		
		return opcao;
	}

	public static boolean cadastraProdutoLimpeza(Scanner input, EstoqueProdutoLimpeza estoqueLimpeza) {
		
		try {
			System.out.println("digite o nome do produto:");
			String nomeProduto = input.next();
			System.out.println("Digite o número do código de barras do produto:");
			int codigoBarras = input.nextInt();
			System.out.println("Digite o Preço de custo:");
			float precoCusto = input.nextFloat();
			System.out.println("Digite o preço de venda:");
			float precoVenda = input.nextFloat();
			System.out.println("Digite a data de validade:");
			String dataValidade = input.next();
			System.out.println("Digite o aroma:");
			String aromaProduto = input.next();
			System.out.println("Digite a parte da casa:");
			String parteDaCasa = input.next();
			
			ProdutoLimpeza produtoLimpeza = new ProdutoLimpeza(nomeProduto, precoVenda, precoCusto, codigoBarras, 
					dataValidade, aromaProduto, parteDaCasa);
			estoqueLimpeza.cadastraProduto(produtoLimpeza);
			
			return true;
		} catch (Exception e) {
			System.out.println("erro ao cadastrar produto, verifique se inseriu todos os valores e se estes são do formato correto");
		}
		return false;
	}

	public static boolean cadastraProdutoAlimenticio(Scanner input, EstoqueProdutoAlimenticio estoqueAlimenticio) {
		
		try {
			System.out.println("Digite o nome do produto:");
			String nomeProduto = input.next();
			System.out.println("Digite o número do código de barras do produto:");
			int codigoBarras = input.nextInt();
			System.out.println("Digite o preço de custo:");
			float precoCusto = input.nextFloat();
			System.out.println("Digite o preço de venda:");
			float precoVenda = input.nextFloat();
			System.out.println("Digite a data de validade:");
			String dataValidade = input.next();
			System.out.println("Digite a origem:");
			String origem = input.next();
			
			ProdutoAlimenticio produtoAlimenticio = new ProdutoAlimenticio(nomeProduto, precoVenda, precoCusto, codigoBarras, 
					dataValidade, origem );
			estoqueAlimenticio.cadastraProduto(produtoAlimenticio);
			
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar produto, verifique se inseriu todos os valores e se estes são do formato correto");
		}
		return false;
	}
	
	public static void removerProdutoLimpeza(Scanner input, EstoqueProdutoLimpeza estoqueLimpeza) {
		System.out.println("Digite o Código de barras do produto a ser removido:");
		int codigoDeBarras = input.nextInt();
		estoqueLimpeza.removeProduto(codigoDeBarras);
	}
	
	public static void removerProdutoAlimenticio(Scanner input, EstoqueProdutoAlimenticio estoqueAlimenticio) {
		System.out.println("Digite o Código de barras do produto a ser removido:");
		int codigoDeBarras = input.nextInt();
		estoqueAlimenticio.removeProduto(codigoDeBarras);
	}
	
	public static void listaDeProdutosLimpeza(EstoqueProdutoLimpeza estoqueLimpeza) {
		for (Produto produto: estoqueLimpeza.listaProdutos().values()) {
			System.out.printf("%s %d %2f %2f %s\n",produto.getNome(),produto.getCodigoDeBarras(),
					produto.getPrecoCusto(),produto.getPrecoVenda(), produto.getDataValidade());
		}
	}
	
	public static void listaDeProdutosAlimenticio(EstoqueProdutoAlimenticio estoqueAlimenticio) {
		for (Produto produto: estoqueAlimenticio.listaProdutos().values()) {
			System.out.printf("%s %d %2f %2f %s\n",produto.getNome(),produto.getCodigoDeBarras(),
					produto.getPrecoCusto(),produto.getPrecoVenda(), produto.getDataValidade());
		}
	}

	public static void alterarPrecoProdutoLimpeza(Scanner input, EstoqueProdutoLimpeza estoqueLimpeza) {
		System.out.println("Digite a porcentagem a ser alterada:");
		int porcentagem = input.nextInt();
		System.out.println("Digite'true' para aumentar e 'false' para diminuir ");
		boolean aumenta = input.nextBoolean();
		estoqueLimpeza.alteraPrecoProdutos(porcentagem, aumenta);
	}
	
	public static void alterarPrecoProdutoAlimenticio(Scanner input, EstoqueProdutoAlimenticio estoqueAlimenticio) {
		System.out.println("Digite a porcentagem a ser alterada:");
		int porcentagem = input.nextInt();
		System.out.println("Digite'true' para aumentar e 'false' para diminuir ");
		boolean aumenta = input.nextBoolean();
		estoqueAlimenticio.alteraPrecoProdutos(porcentagem, aumenta);
	}

	public static void alterarPrecoDeUmProdutoLimpeza(Scanner input, EstoqueProdutoLimpeza estoqueLimpeza) {
		System.out.println("Digite a porcentagem a ser alterada:");
		int porcentagem = input.nextInt();
		System.out.println("Digite'true' para aumentar e 'false' para diminuir:");
		boolean aumenta = input.nextBoolean();
		System.out.println("Digite o código de barras do produto a ser alterado:");
		int codigoDeBarras = input.nextInt();
		estoqueLimpeza.alteraPrecoProduto(porcentagem, aumenta, codigoDeBarras);
	}
	
	public static void alterarPrecoDeUmProdutoAlimenticio(Scanner input, EstoqueProdutoAlimenticio estoqueAlimenticio) {
		System.out.println("Digite a porcentagem a ser alterada:");
		int porcentagem = input.nextInt();
		System.out.println("Digite'true' para aumentar e 'false' para diminuir:");
		boolean aumenta = input.nextBoolean();
		System.out.println("Digite o código de barras do produto a ser alterado:");
		int codigoDeBarras = input.nextInt();
		estoqueAlimenticio.alteraPrecoProduto(porcentagem, aumenta, codigoDeBarras);
	}
	
	
	public static void consultaProdutoLimpeza(Scanner input, EstoqueProdutoLimpeza estoqueLimpeza) {
		System.out.println("Digite o código de barras do produto a ser alterado:");
		int codigoDeBarras = input.nextInt();
		ProdutoLimpeza produto = (ProdutoLimpeza) estoqueLimpeza.consultaProduto(codigoDeBarras);
		System.out.printf("%s %d %2f %2f %s\n",produto.getNome(),produto.getCodigoDeBarras(),
				produto.getPrecoCusto(),produto.getPrecoVenda(), produto.getDataValidade());
		
	}
	
	public static void consultaProdutoAlimenticio(Scanner input, EstoqueProdutoAlimenticio estoqueAlimenticio) {
		System.out.println("Digite o código de barras do produto a ser alterado:");
		int codigoDeBarras = input.nextInt();
		ProdutoAlimenticio produto = (ProdutoAlimenticio) estoqueAlimenticio.consultaProduto(codigoDeBarras);
		System.out.printf("%s %d %2f %2f %s\n",produto.getNome(),produto.getCodigoDeBarras(),
				produto.getPrecoCusto(),produto.getPrecoVenda(), produto.getDataValidade());
		
	}
	
}
