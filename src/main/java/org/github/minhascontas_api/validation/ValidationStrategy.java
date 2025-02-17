package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;

public interface ValidationStrategy {
    void validate(AtualizacaoDespesa dados);
}
