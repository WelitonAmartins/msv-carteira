package br.com.martins.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.martins.dto.CotacaoDTO;
import br.com.martins.dto.ResponseBolsaDTO;
import br.com.martins.exeption.handler.ManipuladorException;
import br.com.martins.service.ConsultarMercadoService;

@RunWith(MockitoJUnitRunner.class)
public class ConsultarMercadoControllerTest {
	
	@InjectMocks
	private ConsultarMercadoController consultarMercadoController;
	
	@Mock
	private ConsultarMercadoService consultarMercadoService;
	
	private MockMvc mock;
	
	@Before
	public void inicializar() {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(consultarMercadoController)
				.setControllerAdvice(new ManipuladorException()).build();
	}

	@Test
	public void deveConsultarBolsaPeloPapel() throws Exception {
		ResponseBolsaDTO dto = new ResponseBolsaDTO( new CotacaoDTO("bidi4", "16.17", "16.30", "16.30", "551700", "2020-01-31", "16.3200"));
		 final String papel = "bidi4";
		 final String retorno = new ObjectMapper().writeValueAsString(dto);
		 
		 when(this.consultarMercadoService.consultarMercado(papel)).thenReturn(dto);
		 
		 mock.perform(get("/mercado?papel=" +papel).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print())
			.andExpect(MockMvcResultMatchers.content().string(retorno));
	}
}
