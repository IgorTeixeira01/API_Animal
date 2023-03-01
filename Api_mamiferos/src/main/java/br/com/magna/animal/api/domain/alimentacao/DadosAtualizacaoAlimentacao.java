package br.com.magna.animal.api.domain.alimentacao;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAlimentacao(
		@NotNull
		Long idAlimentacao,
		String nomeAlimentacao, 
		Boolean fonteAnimal,
		Boolean fonteVegetal) {

}
