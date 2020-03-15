package br.com.zup.gerenciamentoEstoque2.produto;

public class ProdutoAlimenticio extends Produto{

	private String origem;

	public ProdutoAlimenticio(String nome, float precoVenda, float precoCusto, int codigoDeBarras, String dataValidade,
			String origem) {
		super(nome, precoVenda, precoCusto, codigoDeBarras, dataValidade);
		this.origem = origem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	
}
