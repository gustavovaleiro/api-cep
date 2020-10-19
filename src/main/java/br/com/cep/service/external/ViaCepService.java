package br.com.cep.service.external;

import br.com.cep.model.dto.ViaCepResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    @Value("${external.viacep.url}")
    private String viaCepUrl;
    @Value("${external.viacep.url}")
    private String viaCepResponseType;

    public ViaCepResponse findCep(String cep){
        String endereco = this.viaCepUrl + this.viaCepResponseType;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(endereco, ViaCepResponse.class);
    }
}
