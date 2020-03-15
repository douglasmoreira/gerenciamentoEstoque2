package br.com.zup.gerenciamentoEstoque2.produto;

public class Produto {

	private String nome;
	private float precoVenda;
	private float precoCusto;
	private int codigoDeBarras;
	private String dataValidade;
	
	public Produto(String nome, float precoVenda, float precoCusto, int codigoDeBarras, String dataValidade) {
		super();
		this.nome = nome;
		this.precoVenda = precoVenda;
		this.precoCusto = precoCusto;
		this.codigoDeBarras = codigoDeBarras;
		this.dataValidade = dataValidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}
	public float getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}
	public int getCodigoDeBarras() {
		return codigoDeBarras;
	}
	public void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	
}
