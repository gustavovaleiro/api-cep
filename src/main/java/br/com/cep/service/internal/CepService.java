package br.com.cep.service.internal;

import br.com.cep.exceptions.BadRequest;
import br.com.cep.exceptions.ObjectNotFoundException;
import br.com.cep.model.dto.ViaCepResponse;
import br.com.cep.model.entity.Cep;
import br.com.cep.reposity.CepRepository;
import br.com.cep.service.external.ViaCepService;
import br.com.cep.service.mapper.CepMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CepService {

    private final CepRepository cepRepository;
    private final ViaCepService viaCepService;
    private final CepMapper cepMapper;

    @Transactional
    public Cep findCep(String cep){
        if(isInvalidCep(cep)){
            throw new BadRequest("O cep " +  cep + " está em formato invalido");
        }


        Optional<Cep> cepOptional = this.cepRepository.findById(cep);

        return cepOptional.orElse(findCepExternal(cep));


    }

    @Transactional(readOnly = true)
    public List<Cep> findByIbgeUf(String ibge, String uf){
        if(uf == null || uf.isEmpty()){
            return this.cepRepository.findByIbge(ibge);
        }

        return this.cepRepository.findByUfAndIbge(ibge, uf);
    }

    private Cep findCepExternal(String cep){
        ViaCepResponse viaCepResponse = this.viaCepService.findCep(cep);
        if(viaCepResponse == null || viaCepResponse.getCep() == null){
            throw new ObjectNotFoundException("Não foi possivel encontrar o cep " + cep);
        }

        Cep cepEntity = this.cepMapper.toEntity(viaCepResponse);

        return this.cepRepository.save(cepEntity);
    }

    private boolean isInvalidCep(String cep) {
        return cep == null || cep.length() != 8 || !cep.matches("[0-9]*");
    }
}
