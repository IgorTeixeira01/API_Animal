package br.com.magna.animal.api.domain.mamifero;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosAtualizacaoMamifero(
		@NotNull
		Long id, 
		String nome, 
		String cor, 
		@Positive
		Double peso,
		Boolean pelos,
		@PositiveOrZero
		@Max(value = 4)
		Integer patas) {

}
