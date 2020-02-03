package br.com.martins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.martins.dto.CarteiraPessoalDTO;
import br.com.martins.entity.CarteiraPessoal;
import br.com.martins.exeption.PadraoException;
import br.com.martins.repository.CarteiraPessoalRepository;

@Service
public class CarteiraPessoalService {
	
	@Autowired
	private CarteiraPessoalRepository pessoaRepository;
	
	public CarteiraPessoal salvarNovaCarteira(CarteiraPessoalDTO param) {
		
		Double valorDaCarteira = param.getValorMensal() - param.getGastoMensal();
	
		CarteiraPessoal carteiraPessoal = new CarteiraPessoal();
		carteiraPessoal.setNome(param.getNome());
		carteiraPessoal.setIdentidadeRG(param.getIdentidadeRG());
		carteiraPessoal.setValorMensal(param.getValorMensal());
		carteiraPessoal.setGastoMensal(param.getGastoMensal());
		carteiraPessoal.setSaldoTotalCarteira(valorDaCarteira);
		
		return this.pessoaRepository.save(carteiraPessoal);
	}
	
	public List<CarteiraPessoal> listarCarteiras() {
		return this.pessoaRepository.findAll();
	}
	
	public void deletarCarteira(Long id) {
		 this.pessoaRepository.deleteById(id);
	}

	public CarteiraPessoal buscarPorId(Long id)  {
		return this.pessoaRepository.findById(id).orElseThrow(() -> new PadraoException("Essa carteira não existe"));
	}
}
