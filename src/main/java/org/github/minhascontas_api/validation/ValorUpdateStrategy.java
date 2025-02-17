package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;
import org.github.minhascontas_api.domain.Despesa;

public class ValorUpdateStrategy implements UpdateStrategy {

    @Override
    public void update(Despesa despesa, AtualizacaoDespesa dados) {
        if (dados.valor() != null) {
            despesa.setValor(dados.valor());
        }
    }
}
