package org.github.minhascontas_api.validation;

import org.github.minhascontas_api.domain.Categoria;
import org.github.minhascontas_api.domain.dto.DadosAtualizacaoDespesa;
import org.github.minhascontas_api.domain.dto.DadosCadastroDespesa;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaValidationStrategy implements ValidationStrategy {

    public static final String A_DATA_NÃO_PODE_SER_NO_FUTURO = "A data não pode ser no futuro";
    public static final String A_DATA_NÃO_PODE_SER_NULA = "A data não pode ser nula";
    public static final String DESCRICAO_NAO_PODE_SER_VAZIA = "Descrição não pode ser vazia";
    public static final String VALOR_NAO_PODE_SER_NULO = "Valor não pode ser nulo";
    public static final String VALOR_DEVE_SER_POSITIVO = "Valor deve ser positivo";
    public static final String CATEGORIA_NAO_PODE_SER_NULA = "Categoria não pode ser nula";

    @Override
    public void validate(DadosCadastroDespesa dados) {
        validarData(dados.data());
        validarDescricao(dados.descricao());
        validarValor(dados.valor());
        validarCategoria(dados.categoria());
    }

    @Override
    public void validate(DadosAtualizacaoDespesa dados) {
       validarData(dados.data());
       validarDescricao(dados.descricao());
       validarValor(dados.valor());
       validarCategoria(dados.categoria());
    }

    private void validarData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException(A_DATA_NÃO_PODE_SER_NULA);
        }

        if (data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(A_DATA_NÃO_PODE_SER_NO_FUTURO);
        }
    }

    private void validarDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException(DESCRICAO_NAO_PODE_SER_VAZIA);
        }
    }

    private void validarValor(BigDecimal valor) {
        if (valor == null) {
            throw new IllegalArgumentException(VALOR_NAO_PODE_SER_NULO);
        }
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(VALOR_DEVE_SER_POSITIVO);
        }
    }

    private void validarCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException(CATEGORIA_NAO_PODE_SER_NULA);
        }
    }

}
