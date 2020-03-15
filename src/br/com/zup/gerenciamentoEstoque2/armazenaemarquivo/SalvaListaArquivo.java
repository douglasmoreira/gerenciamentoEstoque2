package br.com.zup.gerenciamentoEstoque2.armazenaemarquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import br.com.zup.gerenciamentoEstoque2.produto.ProdutoAlimenticio;
import br.com.zup.gerenciamentoEstoque2.produto.ProdutoLimpeza;

public class SalvaListaArquivo {
	
	public static void salvaProdutosAlimenticiosEmArquivo(Map<Integer,ProdutoAlimenticio> produtos) {
		
		FileWriter writer;
		try {
			writer = new FileWriter("produtosAlimenticio.txt");
			for(ProdutoAlimenticio produto : produtos.values()) {
				String stringProduto = String.format("%-20s %-10d %-10s %-5f %-5f", produto.getNome(), produto.getCodigoDeBarras(),
						produto.getDataValidade(), produto.getPrecoCusto(), produto.getPrecoVenda());
			writer.append(stringProduto);
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void salvaProdutosLimpezasEmArquivo(Map<Integer,ProdutoLimpeza> produtos) {
		
		FileWriter writer;
		try {
			writer = new FileWriter("produtosLimpeza.txt");
			for(ProdutoLimpeza produto : produtos.values()) {
				String stringProduto = String.format("%-20s %-10d %-10s %-5f %-5f", produto.getNome(), produto.getCodigoDeBarras(),
						produto.getDataValidade(), produto.getPrecoCusto(), produto.getPrecoVenda());
			writer.append(stringProduto);
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
