package br.com.zup.gerenciamentoEstoque2.estoque;

import java.util.HashMap;
import java.util.Map;

import br.com.zup.gerenciamentoEstoque2.armazenaemarquivo.SalvaListaArquivo;
import br.com.zup.gerenciamentoEstoque2.produto.Produto;
import br.com.zup.gerenciamentoEstoque2.produto.ProdutoAlimenticio;

public class EstoqueProdutoAlimenticio implements Estoque {

	Map<Integer, ProdutoAlimenticio> produtosAlimenticio = new HashMap<Integer, ProdutoAlimenticio>();
	@Override
	public void alteraPrecoProdutos(float porcentagem, boolean aumenta) {
		
		if(aumenta) {
			for (Produto produto: produtosAlimenticio.values()) {
				produto.setPrecoCusto((produto.getPrecoCusto() * (1 + (porcentagem / 100))));
			}
		} else {
			for (Produto produto: produtosAlimenticio.values()) {
				produto.setPrecoCusto((produto.getPrecoCusto() * (1 - (porcentagem / 100))));
			}
		}
	}

	@Override
	public boolean cadastraProduto(Produto produto) {
		
		try {
			produtosAlimenticio.put(produto.getCodigoDeBarras(), (ProdutoAlimenticio) produto);	
			return true;
		} catch (Exception e) {
			System.out.println("veja se inseriu os valores do produto corretamente.");
		}
		
		return false;
	}

	@Override
	public boolean removeProduto(Integer codigoDeBarras) {
		
		try {
			return produtosAlimenticio.remove(codigoDeBarras, produtosAlimenticio.get(codigoDeBarras));
		} catch (Exception e) {
			System.out.println("Erro ao remover");
		}
		return false;
	}
	
	public Map<Integer, ProdutoAlimenticio> listaProdutos() {
		return produtosAlimenticio;
	}

	@Override
	public boolean alteraPrecoProduto(float porcentagem, boolean aumenta, int codigoDeBarras) {
		
		if(aumenta) {
			produtosAlimenticio.get(codigoDeBarras).setPrecoCusto((produtosAlimenticio.get(codigoDeBarras).getPrecoVenda() * (1 + (porcentagem / 100))));
		} else {
			produtosAlimenticio.get(codigoDeBarras).setPrecoCusto((produtosAlimenticio.get(codigoDeBarras).getPrecoVenda() * (1 - (porcentagem / 100))));
		}
		return false;
	}

	@Override
	public Produto consultaProduto(Integer codigoDeBarras) {
		
		return produtosAlimenticio.get(codigoDeBarras);
	}

	//TODO: O método tem esse tipo de retorno pq? Não é usado onde é chamado.
	@Override
	public boolean gravaListaProdutos() {
		SalvaListaArquivo.salvaProdutosAlimenticiosEmArquivo(produtosAlimenticio);
		return false;
	}

	@Override
	public int quantidadeProdutosEmEstoque() {

		return  produtosAlimenticio.size();
	}

	@Override
	public float mediaValoresVenda() {
		float somaValoresVenda = 0;
		float somaValoresCusto = 0;
		float media;
		for (ProdutoAlimenticio produtoAlimenticio : produtosAlimenticio.values()) {
			 somaValoresVenda += produtoAlimenticio.getPrecoVenda();
			 somaValoresCusto += produtoAlimenticio.getPrecoCusto();
		}
		float mediaVenda = somaValoresVenda / produtosAlimenticio.size();
		float mediacusto = somaValoresCusto / produtosAlimenticio.size();
		
		media = mediaVenda - mediacusto; 
		return media;
	}

	@Override
	public float mediaValorescusto() {
		// TODO Auto-generated method stub
		return 0;
	}
}
