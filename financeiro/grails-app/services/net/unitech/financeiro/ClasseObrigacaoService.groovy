package net.unitech.financeiro

import grails.gorm.services.Service

@Service(ClasseObrigacao)
interface ClasseObrigacaoService {

    ClasseObrigacao get(Serializable id)

    List<ClasseObrigacao> list(Map args)

    Long count()

    void delete(Serializable id)

    ClasseObrigacao save(ClasseObrigacao classeObrigacao)

}