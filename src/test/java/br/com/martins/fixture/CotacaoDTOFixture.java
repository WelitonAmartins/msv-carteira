package br.com.martins.fixture;

import br.com.martins.dto.CotacaoDTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CotacaoDTOFixture implements TemplateLoader {

	@Override
	public void load() {
		Fixture.of(CotacaoDTO.class).addTemplate("valido", new Rule() {
			{	
				add("papel", "BIDI4.SA");
				add("precoAtual", "16.1700");
				add("maiorPrecoDia", "16.3000");
				add("menorPrecoDia", "16.0700");
				add("volumeFinanceiroDoPapel", "551700");
				add("dataDaNegociacao", "2020-01-31");
				add("precoFechamentoDoUltimoPregao", "16.3200");
			}
		}).addTemplate("invalido", new Rule() {
			{			
				add("papel", null);
				add("precoAtual", null);
				add("maiorPrecoDia", null);
				add("menorPrecoDia", null);
				add("volumeFinanceiroDoPapel", null);
				add("dataDaNegociacao", null);
				add("precoFechamentoDoUltimoPregao", null);
			}
		});
	}
	


}
