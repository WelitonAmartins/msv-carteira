package br.com.martins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.martins.entity.CarteiraPessoal;

@Repository
public interface CarteiraPessoalRepository extends JpaRepository<CarteiraPessoal, Long>{

}
