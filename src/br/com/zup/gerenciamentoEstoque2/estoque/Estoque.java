package br.com.zup.gerenciamentoEstoque2.estoque;

import br.com.zup.gerenciamentoEstoque2.produto.Produto;

public interface Estoque {

	public void alteraPrecoProdutos(float porcentagem, boolean aumenta);

	public boolean cadastraProduto(Produto produto);

	public boolean removeProduto (Integer codigoDeBarras);

	//método colocado diretamente na classe para poder usar a lista especifica 
	//Map<Integer, Produto> listaProdutos();

	public boolean alteraPrecoProduto(float porcentagem, boolean aumenta, int codigoDeBarras);

	public Produto consultaProduto(Integer codigoDeBarras);

	public boolean gravaListaProdutos();

	public int quantidadeProdutosEmEstoque();
	
	//método para avaliar os valores medios de venda para se ter noção de ganhos e percas
	public float mediaValoresLucros();

}
