package br.com.martins.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.martins.dto.ResponseBolsaDTO;
import br.com.martins.exeption.PadraoException;
import br.com.martins.util.HttpUtils;

@Service
public class ConsultarMercadoService {
	
	@Autowired
	private RestTemplate restTemplate;
	
//	private static final String ENDPOINT = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=PETR3.SA&interval=15min&outputsize=full&apikey=SUBSTITUA_SUA_KEY_AQUI";

//	private static final String ENDPOINT = "https://api.hgbrasil.com/finance/stock_price";
	
	private static final String ENDPOINT = "https://www.alphavantage.co/query";
//	function=TIME_SERIES_DAILY&symbol=itub4.sa&apikey=XVUVYA86N092PSFR
	
//	private static final Map<String, String> map1 = new  MultiValueMap<String, String>(){{put("function", "GLOBAL_QUOTE");}};
	


	
	public ResponseBolsaDTO consultarMercado(String papel) {
		
		//RestTemplate restTemplate = new RestTemplate();
		
		
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(ENDPOINT)
				.queryParam("function", "GLOBAL_QUOTE").queryParam("symbol", papel+".sa").queryParam("apikey", "XVUVYA86N092PSFR");
		
		
		HttpEntity<String> entity = new HttpEntity<String>(HttpUtils.criarHeader());
		
		ResponseEntity<ResponseBolsaDTO> response = restTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, ResponseBolsaDTO.class);
		
		if(response.getStatusCode() != HttpStatus.OK) {
			throw new PadraoException("Erro ao consultar bolsa de valores");
		}
		
		return response.getBody();
		
	}
}
