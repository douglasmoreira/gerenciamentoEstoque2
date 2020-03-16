package br.com.zup.gerenciamentoEstoque2.estoque;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.gerenciamentoEstoque2.armazenaemarquivo.SalvaListaArquivo;
import br.com.zup.gerenciamentoEstoque2.produto.Produto;
import br.com.zup.gerenciamentoEstoque2.produto.ProdutoLimpeza;

public class EstoqueProdutoLimpeza implements Estoque{
	
	Map<Integer, ProdutoLimpeza> produtosDeLimpeza = new HashMap<Integer, ProdutoLimpeza>();

	@Override
	public void alteraPrecoProdutos(float porcentagem, boolean aumenta) {
		if(aumenta) {
			for (Produto produto: produtosDeLimpeza.values()) {
				produto.setPrecoCusto((produto.getPrecoCusto() * (1 + (porcentagem / 100))));
			}
		} else {
			for (Produto produto: produtosDeLimpeza.values()) {
				produto.setPrecoCusto((produto.getPrecoCusto() * (1 - (porcentagem / 100))));
			}
		}
	}

	@Override
	public boolean cadastraProduto(Produto produto) {
		
		try {
			produtosDeLimpeza.put(produto.getCodigoDeBarras(), (ProdutoLimpeza) produto);	
			return true;
		} catch (Exception e) {
			System.out.println("veja se inseriu os valores do produto corretamente.");
		}
		return false;
	}

	@Override
	public boolean removeProduto(Integer codigoDeBarras) {
		
		try {
			return produtosDeLimpeza.remove(codigoDeBarras, produtosDeLimpeza.get(codigoDeBarras));
		} catch (Exception e) {
			System.out.println("Erro ao remover");
		}
		return false;
	}
	
	public Map<Integer, ProdutoLimpeza> listaProdutos() {
		
		return produtosDeLimpeza;
	}

	@Override
	public boolean alteraPrecoProduto(float porcentagem, boolean aumenta, int codigoDeBarras) {
		
		if(aumenta) {
			produtosDeLimpeza.get(codigoDeBarras).setPrecoCusto((produtosDeLimpeza.get(codigoDeBarras).getPrecoVenda() * (1 + (porcentagem / 100))));
		} else {
			produtosDeLimpeza.get(codigoDeBarras).setPrecoCusto((produtosDeLimpeza.get(codigoDeBarras).getPrecoVenda() * (1 - (porcentagem / 100))));
		}
		return false;
	}

	@Override
	public Produto consultaProduto(Integer codigoDeBarras) {
		
		return produtosDeLimpeza.get(codigoDeBarras);
	}

	@Override
	public boolean gravaListaProdutos() {
		
		SalvaListaArquivo.salvaProdutosLimpezasEmArquivo(produtosDeLimpeza);
		return false;
	}

	@Override
	public int quantidadeProdutosEmEstoque() {

		return produtosDeLimpeza.size();
	}

	@Override
	public float mediaValoresLucros() {
		float somaValoresVenda = 0;
		float somaValoresCusto = 0;
		float media;
		for (ProdutoLimpeza produtoAlimenticio : produtosDeLimpeza.values()) {
			 somaValoresVenda += produtoAlimenticio.getPrecoVenda();
			 somaValoresCusto += produtoAlimenticio.getPrecoCusto();
			 
		}
		float mediaVenda = somaValoresVenda / produtosDeLimpeza.size();
		float mediacusto = somaValoresCusto / produtosDeLimpeza.size();
		
		media = mediaVenda - mediacusto; 
		return media;
	}

	

}
