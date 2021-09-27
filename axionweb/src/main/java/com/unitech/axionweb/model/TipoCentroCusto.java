package com.unitech.axionweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="tipo_centro_custo")
public class TipoCentroCusto implements Serializable {

    @Id
    @Column(name="ticc_sq_tp_centro_custo", nullable=false)
    private Long id;

    @Column(name="ticc_ds_tp_centro_custo", nullable=false)
    private String descricao;

    public TipoCentroCusto() {
    }

    public TipoCentroCusto(Long id) {
        this.id = id;
    }

    public TipoCentroCusto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCentroCusto that = (TipoCentroCusto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescricao(), that.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao());
    }

    @Override
    public String toString() {
        return '\'' + descricao + '\'';
    }
}
