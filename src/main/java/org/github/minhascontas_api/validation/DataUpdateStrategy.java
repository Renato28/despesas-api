package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;
import org.github.minhascontas_api.domain.Despesa;

public class DataUpdateStrategy implements UpdateStrategy {

    @Override
    public void update(Despesa despesa, AtualizacaoDespesa dados) {
        if (dados.data() != null) {
            despesa.setData(dados.data());
        }
    }
}
