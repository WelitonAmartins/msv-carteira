//package br.com.martins.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "Carteira")
//public class Carteira  implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	
//	@Column(name = "VALOR_MENSAL")
//	private Double valorMensal;
//
//	@Column(name = "GASTO_MENSAL")
//	private Double gastoMensal;
//	
//	@Column(name = "SALDO_TOTAL_CARTEIRA")
//	private Double saldoTotalCarteira;
//	
////	@OneToOne
////	private CarteiraPessoal pessoa;
//	
//}
