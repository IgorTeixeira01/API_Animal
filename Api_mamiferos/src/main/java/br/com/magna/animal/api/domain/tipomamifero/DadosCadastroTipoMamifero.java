package br.com.magna.animal.api.domain.tipomamifero;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTipoMamifero(
		@NotBlank
		String nomeTipo,
		@NotNull
		Boolean mamilos,
		@NotNull
		Boolean marsupio,
		@NotNull
		Boolean placenta) {
	
	

}
