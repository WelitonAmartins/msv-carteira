package br.com.martins.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Carteira")
public class Carteira  implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CARTEIRA")
	private Long id;
	
	@Column(name = "DATA_DA_MOVIMENTACAO")
	private Date dataDaMovimentacao;
	
	
//	@JoinColumn(name = "COD_SALDO", referencedColumnName = "COD_SALDO")
//	@OneToMany(mappedBy = "carteira", cascade = {CascadeType.PERSIST})
	
	@ManyToMany
	@JoinTable(name="TB_CARTEIRA_SALDO",  
                joinColumns=@JoinColumn(name="COD_CARTEIRA"),   
                inverseJoinColumns=@JoinColumn(name="COD_SALDO")) 
	private List<SaldoCarteira> saldo = new ArrayList<>();
	
////	@JoinColumn(name = "COD_DEBITO", referencedColumnName = "COD_DEBITO")
//	@OneToMany(mappedBy = "carteira_debitos", cascade = {CascadeType.PERSIST})
	
	@ManyToMany
	@JoinTable(name="TB_CARTEIRA_DEBITO",  
                joinColumns=@JoinColumn(name="COD_CARTEIRA"),   
                inverseJoinColumns=@JoinColumn(name="COD_DEBITO")) 
	private List<Debitos> dabitos = new ArrayList<>();
}
