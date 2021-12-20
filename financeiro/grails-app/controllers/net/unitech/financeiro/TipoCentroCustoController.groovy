package net.unitech.financeiro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoCentroCustoController {

    TipoCentroCustoService tipoCentroCustoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoCentroCustoService.list(params), model:[tipoCentroCustoCount: tipoCentroCustoService.count()]
    }

    def show(Long id) {
        respond tipoCentroCustoService.get(id)
    }

    def create() {
        respond new TipoCentroCusto(params)
    }

    def save(TipoCentroCusto tipoCentroCusto) {
        if (tipoCentroCusto == null) {
            notFound()
            return
        }

        try {
            tipoCentroCustoService.save(tipoCentroCusto)
        } catch (ValidationException e) {
            respond tipoCentroCusto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoCentroCusto.label', default: 'TipoCentroCusto'), tipoCentroCusto.id])
                redirect tipoCentroCusto
            }
            '*' { respond tipoCentroCusto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoCentroCustoService.get(id)
    }

    def update(TipoCentroCusto tipoCentroCusto) {
        if (tipoCentroCusto == null) {
            notFound()
            return
        }

        try {
            tipoCentroCustoService.save(tipoCentroCusto)
        } catch (ValidationException e) {
            respond tipoCentroCusto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoCentroCusto.label', default: 'TipoCentroCusto'), tipoCentroCusto.id])
                redirect tipoCentroCusto
            }
            '*'{ respond tipoCentroCusto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoCentroCustoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoCentroCusto.label', default: 'TipoCentroCusto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoCentroCusto.label', default: 'TipoCentroCusto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
