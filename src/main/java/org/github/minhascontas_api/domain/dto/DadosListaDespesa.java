package org.github.minhascontas_api.domain.dto;

import org.github.minhascontas_api.domain.Categoria;
import org.github.minhascontas_api.domain.Despesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListaDespesa(String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {
    public DadosListaDespesa(Despesa despesa) {
        this(despesa.getDescricao(), despesa.getValor(), despesa.getData(),
                despesa.getCategoria());
    }
}
