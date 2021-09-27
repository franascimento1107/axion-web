package com.unitech.axionweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="competencia")
public class Competencia implements Serializable {

    @Id
    @Column(name="comp_sq_competencia", nullable=false)
    private Long id;

    @Column(name="comp_nr_mes", nullable=false)
    private Integer mes;

    @Column(name="comp_nr_ano", nullable=false)
    private Integer ano;

}
