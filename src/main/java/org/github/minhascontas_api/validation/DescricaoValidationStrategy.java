package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;

public class DescricaoValidationStrategy implements ValidationStrategy {

    @Override
    public void validate(AtualizacaoDespesa dados) {
        if (dados.descricao() != null && dados.descricao().isBlank()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
    }
}
