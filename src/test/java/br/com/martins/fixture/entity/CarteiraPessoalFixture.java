package br.com.martins.fixture.entity;

import br.com.martins.entity.CarteiraPessoal;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CarteiraPessoalFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(CarteiraPessoal.class).addTemplate("valido", new Rule() {
			{	
				add("id", random(Long.class, range(1L, 500L)));
				add("nome", name());
				add("valorMensal",  random(Double.class, range(1000, 5000)));
				add("gastoMensal", random(Double.class, range(1000, 5000)));
				add("saldoTotalCarteira", random(Double.class, range(1000, 5000)));
			}
		}).addTemplate("invalido", new Rule() {
			{			
				add("id", null);
				add("nome", null);
				add("valorMensal", null);
				add("gastoMensal", null);
				add("saldoTotalCarteira", null);
			}
		});
	}
	


}
