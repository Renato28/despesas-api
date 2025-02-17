package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;

import java.math.BigDecimal;

public class ValorValidationStrategy implements ValidationStrategy {

    public static final String O_VALOR_DEVE_SER_MAIOR_QUE_ZERO = "O valor deve ser maior que zero";

    @Override
    public void validate(AtualizacaoDespesa dados) {
        if (dados.valor() == null || dados.valor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(O_VALOR_DEVE_SER_MAIOR_QUE_ZERO);
        }
    }
}
