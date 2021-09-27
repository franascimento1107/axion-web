package com.unitech.axionweb.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable {

    @Id
    @Column(name="forn_sq_fornecedor", nullable=false)
    private Long id;

    @Column(name="forn_nm_fantasia", nullable=false)
    private String fantasia;

    @Column(name="forn_nm_razao_social", nullable=false)
    private String razaoSocial;

    @ManyToOne
    private ClasseObrigacao classe;

}
