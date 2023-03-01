package br.com.magna.animal.api.domain.mamifero;

import br.com.magna.animal.api.domain.alimentacao.Alimentacao;
import br.com.magna.animal.api.domain.tipomamifero.TipoMamifero;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record DadosCadastroMamifero(
		@NotBlank
		String nome,
		
		@NotBlank
		String cor,
		
		@NotNull
		@Positive
		Double peso, 
		
		@NotNull
		VertebradoInvertebrado vertebradoInvertebrado, 
		
		@NotNull
		TipoSangue tipoSangue,
		
		@NotNull
		Boolean pelos, 
		
		@NotNull
		@AssertTrue
		Boolean glandulasMamarias, 
		
		@NotNull
		@PositiveOrZero
		@Max(value = 4)
		Integer patas,
		
		@NotNull
		TipoMamifero tipoMamifero,
		
		@NotNull
		Alimentacao alimentacao) {

}
