package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.DadosAtualizacaoDespesa;
import org.github.minhascontas_api.domain.dto.DadosCadastroDespesa;

public interface ValidationStrategy {

    void validate(DadosCadastroDespesa dados);
    void validate(DadosAtualizacaoDespesa dados);
}
