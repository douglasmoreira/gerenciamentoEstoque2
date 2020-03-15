package br.com.zup.gerenciamentoEstoque2.produto;

public class ProdutoLimpeza extends Produto {
	
	private String aroma;
	private String parteDaCasa;
	
	
	public ProdutoLimpeza(String nome, float precoVenda, float precoCusto, int codigoDeBarras, String dataValidade,
			String aroma, String parteDaCasa) {
		super(nome, precoVenda, precoCusto, codigoDeBarras, dataValidade);
		this.aroma = aroma;
		this.parteDaCasa = parteDaCasa;
	}
	public String getAroma() {
		return aroma;
	}
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}
	public String getParteDaCasa() {
		return parteDaCasa;
	}
	public void setParteDaCasa(String parteDaCasa) {
		this.parteDaCasa = parteDaCasa;
	}
	
	

}
