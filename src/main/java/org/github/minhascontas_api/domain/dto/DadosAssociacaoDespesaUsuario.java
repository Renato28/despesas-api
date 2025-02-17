package org.github.minhascontas_api.domain.dto;

import org.github.minhascontas_api.domain.Despesa;

import java.math.BigDecimal;

public record DadosAssociacaoDespesaUsuario(String descricao, BigDecimal valor, String usuario) {
    public DadosAssociacaoDespesaUsuario(Despesa despesa) {
        this(despesa.getDescricao(), despesa.getValor(), despesa.getUsuario().getNome());
    }
}
