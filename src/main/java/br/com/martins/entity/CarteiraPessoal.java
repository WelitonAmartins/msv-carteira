package br.com.martins.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CARTEIRA_PESSOAL2")
public class CarteiraPessoal  implements Serializable {
	private static final long serialVersionUID = 1L;
//	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "IDENTIDADE_RG")
	private String identidadeRG;
	
	@Column(name = "VALOR_MENSAL")
	private Double valorMensal;

	@Column(name = "GASTO_MENSAL")
	private Double gastoMensal;
	
	@Column(name = "SALDO_TOTAL_CARTEIRA")
	private Double saldoTotalCarteira;
	


}
