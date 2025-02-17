package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;

import java.time.LocalDate;

public class DataValidationStrategy implements ValidationStrategy {

    public static final String A_DATA_NÃO_PODE_SER_NO_FUTURO = "A data não pode ser no futuro";
    public static final String A_DATA_NÃO_PODE_SER_NULA = "A data não pode ser nula";

    @Override
    public void validate(AtualizacaoDespesa dados) {
        if (dados.data() == null) {
            throw new IllegalArgumentException(A_DATA_NÃO_PODE_SER_NULA);
        }

        if (dados.data().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(A_DATA_NÃO_PODE_SER_NO_FUTURO);
        }
    }
}
