package br.com.martins.fixture;

import br.com.martins.dto.CotacaoDTO;
import br.com.martins.dto.ResponseBolsaDTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ResponseBolsaDTOFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(ResponseBolsaDTO.class).addTemplate("valido", new Rule() {
			{
				add("cotacao", has(3).of(CotacaoDTO.class, "valido"));
			}
		}).addTemplate("invalido", new Rule() {
			{
				add("cotacao", has(2).of(CotacaoDTO.class, "invalido"));
			}
		});
		
	}

}
