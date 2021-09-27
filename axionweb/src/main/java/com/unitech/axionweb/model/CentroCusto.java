package com.unitech.axionweb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="centro_custo")
public class CentroCusto implements Serializable {

    @Id
    @Column(name="cecu_sq_centro_custo", nullable=false)
    private Long id;

    @Column(name="cecu_nm_centro_custo", nullable=false)
    private String nome;

    @ManyToOne
    private TipoCentroCusto tipo;

}
