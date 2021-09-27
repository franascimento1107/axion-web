package com.unitech.axionweb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="obrigacao")
public class Obrigacao implements Serializable {

    @Id
    @Column(name="obrg_sq_obrigacao", nullable=false)
    private Long id;

    @ManyToOne
    private CentroCusto centroCusto;

    @ManyToOne
    private Fornecedor fornecedor;

    @Column(name="obrg_nr_dia_vencim", nullable=false)
    private Integer diaVencimento;

    @Column(name="obrg_in_debito_auto", nullable=false)
    private Boolean debitoAutormatico;

    @ManyToOne
    private PeriodoObrigacao periodo;
}
