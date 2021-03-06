package br.com.cep.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "TCidade")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Cidade {

  @Id
  @Column(length = 20, nullable = false, unique = true)
  private String ibge;

  @Column(length = 2, nullable = false)
  private String uf;
  @Column(length = 100, nullable = false)
  private String localidade;
  @OneToMany(mappedBy = "cidade")
  private List<Cep> ceps; 
  
}
