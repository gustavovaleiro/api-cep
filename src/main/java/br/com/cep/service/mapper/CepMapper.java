package br.com.cep.service.mapper;

import br.com.cep.model.dto.ViaCepResponse;
import br.com.cep.model.entity.Cep;
import br.com.cep.model.entity.Cidade;
import org.springframework.stereotype.Component;

@Component
public class CepMapper {

    public Cep toEntity(ViaCepResponse response){
        return Cep.builder()
                .cep(response.getCep())
                .cidade(
                        Cidade.builder()
                                .ibge(response.getIbge())
                                .localidade(response.getLocalidade())
                                .uf(response.getUf())
                        .build()
                )
                .bairro(response.getBairro())
                .complemento(response.getComplemento())
                .logradouro(response.getLogradouro())
                .build();
    }
}
