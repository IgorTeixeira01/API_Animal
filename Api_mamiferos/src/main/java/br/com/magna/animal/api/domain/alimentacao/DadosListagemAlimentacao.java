package br.com.magna.animal.api.domain.alimentacao;

public record DadosListagemAlimentacao(Long idAlimentacao, String nomeAlimentacao, Boolean fonteAnimal, Boolean fonteVegetal) {

	public DadosListagemAlimentacao(Alimentacao alimentacao) {
		this(alimentacao.getIdAlimentacao(), alimentacao.getNomeAlimentacao(), alimentacao.getFonteAnimal(), 
				alimentacao.getFonteVegetal());
	}
}
