package br.com.martins.service;


import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.martins.dto.CotacaoDTO;
import br.com.martins.dto.ResponseBolsaDTO;
import br.com.martins.exeption.PadraoException;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarMercadoServiceTest {
	
	@InjectMocks
	private ConsultarMercadoService consultarMercadoService;
	
	@Mock
	private RestTemplate restTemplate;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private static final String ENDPOINT = "https://www.alphavantage.co/query";
	
	 @BeforeClass
	 public static void configurar() {
	     FixtureFactoryLoader.loadTemplates("br.com.martins.fixture");
	     
	 }
	
	 @Test
	 public void deveFazerRequestNaBolsaComSucesso() {
//		 final ResponseBolsaDTO dto = Fixture.from(ResponseBolsaDTO.class).gimme("valido");
		 
		 ResponseBolsaDTO dto = new ResponseBolsaDTO( new CotacaoDTO("bidi4", "16.17", "16.30", "16.30", "551700", "2020-01-31", "16.3200"));
		 final String papel = "bidi4";
		
		
		ResponseEntity<ResponseBolsaDTO> response = new ResponseEntity<ResponseBolsaDTO>(dto,
				HttpStatus.OK);
		
			when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class),
					eq(ResponseBolsaDTO.class))).thenReturn(response);
			
		 ResponseBolsaDTO resultado = this.consultarMercadoService.consultarMercado(papel);
		 
		 assertNotNull(resultado);
	 }
	 
	 @Test
	 public void deveFazerRequestNaBolsaComException() {
		 final String msgErro = "Erro ao consultar bolsa de valores";
//		 ResponseEntity<ResponseBolsaDTO> response = new ResponseEntity<ResponseBolsaDTO>(HttpStatus.NOT_FOUND);
		 ResponseEntity<ResponseBolsaDTO> response = new ResponseEntity<ResponseBolsaDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		 
		 expectedException.expect(PadraoException.class);
		 expectedException.expectMessage(msgErro);
	
		 
		 when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class),
					eq(ResponseBolsaDTO.class))).thenReturn(response);
		 
		 this.consultarMercadoService.consultarMercado(null);
	 }
}
