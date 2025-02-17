package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.dto.AtualizacaoDespesa;
import org.github.minhascontas_api.domain.Despesa;

public class DescricaoUpdateStrategy implements UpdateStrategy {

    @Override
    public void update(Despesa despesa, AtualizacaoDespesa dados) {
        if (dados.descricao() != null && !dados.descricao().isBlank()) {
            despesa.setDescricao(dados.descricao());
        }
    }
}
