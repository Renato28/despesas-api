package org.github.minhascontas_api.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.github.minhascontas_api.domain.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroDespesa(
        @NotBlank(message = "Descrição não pode ser vazia.")
        String descricao,
        @NotNull(message = "Valor não pode ser nulo.")
        BigDecimal valor,
        @NotNull(message = "Data não pode ser vazia.")
        LocalDate data,
        @NotBlank(message = "Categoria não pode ser vazia")
        Categoria categoria,
        boolean pago) {
}
