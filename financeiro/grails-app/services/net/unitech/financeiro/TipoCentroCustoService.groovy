package net.unitech.financeiro

import grails.gorm.services.Service

@Service(TipoCentroCusto)
interface TipoCentroCustoService {

    TipoCentroCusto get(Serializable id)

    List<TipoCentroCusto> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoCentroCusto save(TipoCentroCusto tipoCentroCusto)

}