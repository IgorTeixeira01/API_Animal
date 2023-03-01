package br.com.magna.animal.api.domain.tipomamifero;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoTipoMamifero(
		@NotNull
		Long idTipo,
		String nomeTipo, 
		Boolean mamilos,
		Boolean marsupio,
		Boolean placenta) {

}
