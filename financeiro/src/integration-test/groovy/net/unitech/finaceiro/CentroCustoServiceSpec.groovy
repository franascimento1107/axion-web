package net.unitech.finaceiro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CentroCustoServiceSpec extends Specification {

    CentroCustoService centroCustoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CentroCusto(...).save(flush: true, failOnError: true)
        //new CentroCusto(...).save(flush: true, failOnError: true)
        //CentroCusto centroCusto = new CentroCusto(...).save(flush: true, failOnError: true)
        //new CentroCusto(...).save(flush: true, failOnError: true)
        //new CentroCusto(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //centroCusto.id
    }

    void "test get"() {
        setupData()

        expect:
        centroCustoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CentroCusto> centroCustoList = centroCustoService.list(max: 2, offset: 2)

        then:
        centroCustoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        centroCustoService.count() == 5
    }

    void "test delete"() {
        Long centroCustoId = setupData()

        expect:
        centroCustoService.count() == 5

        when:
        centroCustoService.delete(centroCustoId)
        sessionFactory.currentSession.flush()

        then:
        centroCustoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CentroCusto centroCusto = new CentroCusto()
        centroCustoService.save(centroCusto)

        then:
        centroCusto.id != null
    }
}
