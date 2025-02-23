package org.github.minhascontas_api.service;

import lombok.RequiredArgsConstructor;
import org.github.minhascontas_api.domain.dto.DadosAtualizacaoDespesa;
import org.github.minhascontas_api.domain.dto.DadosCadastroDespesa;
import org.github.minhascontas_api.validation.ValidationStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidationService {

    private final List<ValidationStrategy> validationStrategies;

    public void validar(DadosCadastroDespesa dados) {
        validationStrategies.forEach(strategy -> strategy.validate(dados));
    }

    public void validar(DadosAtualizacaoDespesa dados) {
        validationStrategies.forEach(strategy -> strategy.validate(dados));
    }

}
