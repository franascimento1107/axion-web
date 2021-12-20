package net.unitech.finaceiro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClasseObrigacaoServiceSpec extends Specification {

    ClasseObrigacaoService classeObrigacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ClasseObrigacao(...).save(flush: true, failOnError: true)
        //new ClasseObrigacao(...).save(flush: true, failOnError: true)
        //ClasseObrigacao classeObrigacao = new ClasseObrigacao(...).save(flush: true, failOnError: true)
        //new ClasseObrigacao(...).save(flush: true, failOnError: true)
        //new ClasseObrigacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //classeObrigacao.id
    }

    void "test get"() {
        setupData()

        expect:
        classeObrigacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ClasseObrigacao> classeObrigacaoList = classeObrigacaoService.list(max: 2, offset: 2)

        then:
        classeObrigacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        classeObrigacaoService.count() == 5
    }

    void "test delete"() {
        Long classeObrigacaoId = setupData()

        expect:
        classeObrigacaoService.count() == 5

        when:
        classeObrigacaoService.delete(classeObrigacaoId)
        sessionFactory.currentSession.flush()

        then:
        classeObrigacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ClasseObrigacao classeObrigacao = new ClasseObrigacao()
        classeObrigacaoService.save(classeObrigacao)

        then:
        classeObrigacao.id != null
    }
}
