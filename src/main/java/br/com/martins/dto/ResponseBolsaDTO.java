package br.com.martins.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBolsaDTO {
	
	@JsonAlias("Global Quote")
	private CotacaoDTO cotacao;
	



		

	

}
