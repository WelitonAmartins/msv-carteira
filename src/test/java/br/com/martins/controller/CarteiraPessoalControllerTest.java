package br.com.martins.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
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

import br.com.martins.entity.CarteiraPessoal;
import br.com.martins.exeption.handler.ManipuladorException;
import br.com.martins.service.CarteiraPessoalService;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class CarteiraPessoalControllerTest {
	
	private static final String URL ="/carteira-pessoal";

	@InjectMocks
	private CarteiraPessoalController carteiraPessoalController;
	
	@Mock
	private CarteiraPessoalService carteiraPessoalService;
	
	private MockMvc mock;
	
	@Before
	public void inicializar() {
		MockitoAnnotations.initMocks(this);
		mock = MockMvcBuilders.standaloneSetup(carteiraPessoalController)
				.setControllerAdvice(new ManipuladorException()).build();
	}
	
	@BeforeClass
	public static void configurar() {
		FixtureFactoryLoader.loadTemplates("br.com.martins.fixture.entity");
	}
	
	@Test
	public void deveRetornarCarteiras() throws Exception {
		final List<CarteiraPessoal> carteiras = Fixture.from(CarteiraPessoal.class).gimme(3, "valido");
		final String retorno = new ObjectMapper().writeValueAsString(carteiras);
		
		when(this.carteiraPessoalService.listarCarteiras()).thenReturn(carteiras);
		
		mock.perform(get(URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print())
		.andExpect(MockMvcResultMatchers.content().string(retorno));

	}
	
	@Test
	public void deveApagarProdutoComSucesso() throws Exception {
		final Long codigo = 5L;

		mock.perform(delete(URL + "/" + codigo).contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isNoContent());
	}
	
	@Test
	public void deveRetornarCarteiraPorId() throws Exception {
		final Long codigo = 5L;
		final CarteiraPessoal carteiras = Fixture.from(CarteiraPessoal.class).gimme("valido");
		final String retorno = new ObjectMapper().writeValueAsString(carteiras);
		
		when(this.carteiraPessoalService.buscarPorId(any(Long.class))).thenReturn(carteiras);
		
		mock.perform(get(URL + "/" + codigo).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andDo(print())
		.andExpect(MockMvcResultMatchers.content().string(retorno));
		
	}
}
