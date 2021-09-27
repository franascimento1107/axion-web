package com.unitech.axionweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="lanca_obrig")
public class LancamentoObrigacao implements Serializable {

    @Id
    @Column(name="laob_sq_lanc_obrig", nullable=false)
    private Long id;

    @ManyToOne
    private Obrigacao obrigacao;

    @ManyToOne
    private Competencia competencia;

    @Column(name="obrg_dt_vencimento", nullable=false)
    private LocalDate dataVencimento;

    @Column(name="obrg_vl_vencimento")
    private Double valorVencimento;

    @Column(name="obrg_dt_operacao")
    private LocalDate dataOperacao;

    @Column(name="obrg_vl_operacao")
    private Double valorOperacao;
}
