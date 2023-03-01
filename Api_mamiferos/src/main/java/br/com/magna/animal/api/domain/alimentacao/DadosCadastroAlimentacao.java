package br.com.magna.animal.api.domain.alimentacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroAlimentacao(
		@NotBlank
		String nomeAlimentacao,
		@NotNull
		Boolean fonteAnimal,
		@NotNull
		Boolean fonteVegetal) {

}
