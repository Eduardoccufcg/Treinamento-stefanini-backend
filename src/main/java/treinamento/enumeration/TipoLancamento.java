package treinamento.enumeration;

public enum TipoLancamento {
	
	RECEITA("receita"),DESPESA("despesa");
	
	private String valor;
	
	private TipoLancamento(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}


}
