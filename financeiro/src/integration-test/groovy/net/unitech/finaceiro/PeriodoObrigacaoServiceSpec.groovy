package net.unitech.finaceiro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PeriodoObrigacaoServiceSpec extends Specification {

    PeriodoObrigacaoService periodoObrigacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PeriodoObrigacao(...).save(flush: true, failOnError: true)
        //new PeriodoObrigacao(...).save(flush: true, failOnError: true)
        //PeriodoObrigacao periodoObrigacao = new PeriodoObrigacao(...).save(flush: true, failOnError: true)
        //new PeriodoObrigacao(...).save(flush: true, failOnError: true)
        //new PeriodoObrigacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //periodoObrigacao.id
    }

    void "test get"() {
        setupData()

        expect:
        periodoObrigacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PeriodoObrigacao> periodoObrigacaoList = periodoObrigacaoService.list(max: 2, offset: 2)

        then:
        periodoObrigacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        periodoObrigacaoService.count() == 5
    }

    void "test delete"() {
        Long periodoObrigacaoId = setupData()

        expect:
        periodoObrigacaoService.count() == 5

        when:
        periodoObrigacaoService.delete(periodoObrigacaoId)
        sessionFactory.currentSession.flush()

        then:
        periodoObrigacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PeriodoObrigacao periodoObrigacao = new PeriodoObrigacao()
        periodoObrigacaoService.save(periodoObrigacao)

        then:
        periodoObrigacao.id != null
    }
}
