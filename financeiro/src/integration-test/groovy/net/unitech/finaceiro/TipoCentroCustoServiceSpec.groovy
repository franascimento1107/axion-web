package net.unitech.finaceiro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoCentroCustoServiceSpec extends Specification {

    TipoCentroCustoService tipoCentroCustoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoCentroCusto(...).save(flush: true, failOnError: true)
        //new TipoCentroCusto(...).save(flush: true, failOnError: true)
        //TipoCentroCusto tipoCentroCusto = new TipoCentroCusto(...).save(flush: true, failOnError: true)
        //new TipoCentroCusto(...).save(flush: true, failOnError: true)
        //new TipoCentroCusto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoCentroCusto.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoCentroCustoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoCentroCusto> tipoCentroCustoList = tipoCentroCustoService.list(max: 2, offset: 2)

        then:
        tipoCentroCustoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoCentroCustoService.count() == 5
    }

    void "test delete"() {
        Long tipoCentroCustoId = setupData()

        expect:
        tipoCentroCustoService.count() == 5

        when:
        tipoCentroCustoService.delete(tipoCentroCustoId)
        sessionFactory.currentSession.flush()

        then:
        tipoCentroCustoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoCentroCusto tipoCentroCusto = new TipoCentroCusto()
        tipoCentroCustoService.save(tipoCentroCusto)

        then:
        tipoCentroCusto.id != null
    }
}
