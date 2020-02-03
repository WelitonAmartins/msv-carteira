package br.com.martins.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.martins.entity.CarteiraPessoal;
import br.com.martins.exeption.PadraoException;
import br.com.martins.repository.CarteiraPessoalRepository;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@RunWith(MockitoJUnitRunner.class)
public class CarteiraPessoalServiceTest {

	@InjectMocks
	private CarteiraPessoalService carteiraPessoalService;
	
	@Mock
	private CarteiraPessoalRepository carteiraPessoalRepository;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@BeforeClass
	public static void configurar() {
		FixtureFactoryLoader.loadTemplates("br.com.martins.fixture.entity");
	}
	
	@Test
	public void deveRetornarCarteiras() {
		final List<CarteiraPessoal> carteiras = Fixture.from(CarteiraPessoal.class).gimme(3, "valido");
		
		when(carteiraPessoalRepository.findAll()).thenReturn(carteiras);
		
		List<CarteiraPessoal> resultado = this.carteiraPessoalService.listarCarteiras();
		
		assertEquals(carteiras, resultado);
		assertEquals(carteiras.size(), resultado.size());
		verify(this.carteiraPessoalRepository, timeout(1)).findAll();
		
	}
	
	@Test
	public void deveBuscarCarteiraPorIdComSucesso() {
		final CarteiraPessoal carteiras = Fixture.from(CarteiraPessoal.class).gimme("valido");
		when(this.carteiraPessoalRepository.findById(any(Long.class))).thenReturn(Optional.of(carteiras));
		
		CarteiraPessoal resultado = this.carteiraPessoalService.buscarPorId(any(Long.class));
		
		assertNotNull(resultado);
		assertEquals(carteiras, resultado);
		assertEquals(carteiras.getId(), resultado.getId());
		verify(this.carteiraPessoalRepository, timeout(1)).findById(any(Long.class));
		
	}
	
	@Test
	public void deveBuscarCarteiraPorIdException() {
		final String msgErro = "Essa carteira não existe";
		expectedException.expect(PadraoException.class);
		expectedException.expectMessage(msgErro);
		
		when(this.carteiraPessoalRepository.findById(any(Long.class))).thenReturn(Optional.ofNullable(null));
		
		this.carteiraPessoalService.buscarPorId(any(Long.class));
		
	}
}
