package net.unitech.financeiro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PeriodoObrigacaoController {

    PeriodoObrigacaoService periodoObrigacaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond periodoObrigacaoService.list(params), model:[periodoObrigacaoCount: periodoObrigacaoService.count()]
    }

    def show(Long id) {
        respond periodoObrigacaoService.get(id)
    }

    def create() {
        respond new PeriodoObrigacao(params)
    }

    def save(PeriodoObrigacao periodoObrigacao) {
        if (periodoObrigacao == null) {
            notFound()
            return
        }

        try {
            periodoObrigacaoService.save(periodoObrigacao)
        } catch (ValidationException e) {
            respond periodoObrigacao.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'periodoObrigacao.label', default: 'PeriodoObrigacao'), periodoObrigacao.id])
                redirect periodoObrigacao
            }
            '*' { respond periodoObrigacao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond periodoObrigacaoService.get(id)
    }

    def update(PeriodoObrigacao periodoObrigacao) {
        if (periodoObrigacao == null) {
            notFound()
            return
        }

        try {
            periodoObrigacaoService.save(periodoObrigacao)
        } catch (ValidationException e) {
            respond periodoObrigacao.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'periodoObrigacao.label', default: 'PeriodoObrigacao'), periodoObrigacao.id])
                redirect periodoObrigacao
            }
            '*'{ respond periodoObrigacao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        periodoObrigacaoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'periodoObrigacao.label', default: 'PeriodoObrigacao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'periodoObrigacao.label', default: 'PeriodoObrigacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
