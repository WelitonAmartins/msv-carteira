package br.com.martins.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoDTO {
	
	@JsonAlias("01. symbol")
	private String papel;
	
	@JsonAlias("05. price")
	private String precoAtual;
	
	@JsonAlias("03. high")
	private String maiorPrecoDia;
	
	@JsonAlias("04. low")
	private String menorPrecoDia;
	
	@JsonAlias("06. volume")
	private String volumeFinanceiroDoPapel;
	
	@JsonAlias("07. latest trading day")
	private String dataDaNegociacao;
	
	@JsonAlias("08. previous close")
	private String precoFechamentoDoUltimoPregao;		

}
