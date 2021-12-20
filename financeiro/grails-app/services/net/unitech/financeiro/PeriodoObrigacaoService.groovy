package net.unitech.financeiro

import grails.gorm.services.Service

@Service(PeriodoObrigacao)
interface PeriodoObrigacaoService {

    PeriodoObrigacao get(Serializable id)

    List<PeriodoObrigacao> list(Map args)

    Long count()

    void delete(Serializable id)

    PeriodoObrigacao save(PeriodoObrigacao periodoObrigacao)

}