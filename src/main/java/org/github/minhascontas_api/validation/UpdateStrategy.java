package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;
import org.github.minhascontas_api.domain.Despesa;

public interface UpdateStrategy {
    void update(Despesa despesa, AtualizacaoDespesa dados);
}
