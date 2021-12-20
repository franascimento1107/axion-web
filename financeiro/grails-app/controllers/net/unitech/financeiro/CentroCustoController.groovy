package net.unitech.financeiro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CentroCustoController {

    CentroCustoService centroCustoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond centroCustoService.list(params), model:[centroCustoCount: centroCustoService.count()]
    }

    def show(Long id) {
        respond centroCustoService.get(id)
    }

    def create() {
        respond new CentroCusto(params)
    }

    def save(CentroCusto centroCusto) {
        if (centroCusto == null) {
            notFound()
            return
        }

        try {
            centroCustoService.save(centroCusto)
        } catch (ValidationException e) {
            respond centroCusto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'centroCusto.label', default: 'CentroCusto'), centroCusto.id])
                redirect centroCusto
            }
            '*' { respond centroCusto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond centroCustoService.get(id)
    }

    def update(CentroCusto centroCusto) {
        if (centroCusto == null) {
            notFound()
            return
        }

        try {
            centroCustoService.save(centroCusto)
        } catch (ValidationException e) {
            respond centroCusto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'centroCusto.label', default: 'CentroCusto'), centroCusto.id])
                redirect centroCusto
            }
            '*'{ respond centroCusto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        centroCustoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'centroCusto.label', default: 'CentroCusto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'centroCusto.label', default: 'CentroCusto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
