package br.com.cep.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ViaCepResponse {

    private String cep;

    private String uf;

    private String localidade;

    private String bairro;

    private String logradouro;

    private String complemento;

    private String unidade;

    private String ibge;


}
