package com.unitech.axionweb.repository;

import com.unitech.axionweb.model.TipoCentroCusto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoCentroCustoRepository extends JpaRepository<TipoCentroCusto, Long> {

    /**
     * Encontra todos os tipos de descrição semenlhante.
     *
     * @param descricao
     * @return lista de tipos
     */
    List<TipoCentroCusto> findByDescricao(String descricao);

}
