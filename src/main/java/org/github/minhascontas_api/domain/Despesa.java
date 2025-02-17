package org.github.minhascontas_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.github.minhascontas_api.domain.dto.DadosCadastroDespesa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "despesas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despesa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    private Categoria categoria;

    private boolean pago;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Despesa(DadosCadastroDespesa dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.data = dados.data();
        this.categoria = dados.categoria();
        this.pago = false;
    }
}
