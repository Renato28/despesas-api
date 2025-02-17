package org.github.minhascontas_api.domain.dto;

import org.github.minhascontas_api.domain.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AtualizacaoDespesa(
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate data,
        Categoria categoria,
        boolean pago) {
}
