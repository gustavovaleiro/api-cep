package br.com.cep.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TCep")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cep {
	@Id
	@Column(name = "CEP",nullable = false, length = 10)
	private String cep;
	@Column(name = "LOGRADOURO", nullable = false, length = 255)
	private String logradouro;
	@Column(name = "COMPLEMENTO",  length = 255)
	private String complemento;
	@Column(name = "BAIRRO",  length = 50)
	private String bairro;

	@ManyToOne
	@JoinColumn(name = "IBGE", nullable = false)
	private Cidade cidade;

}
