package org.github.minhascontas_api.domain.dto;

import org.github.minhascontas_api.domain.Despesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DespesaResponse(String descricao, BigDecimal valor, LocalDate data) {
    public DespesaResponse(Despesa despesa) {
        this(despesa.getDescricao(), despesa.getValor(), despesa.getData());
    }
}
