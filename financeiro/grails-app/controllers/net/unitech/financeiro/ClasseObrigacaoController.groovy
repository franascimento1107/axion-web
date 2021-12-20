package net.unitech.financeiro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClasseObrigacaoController {

    ClasseObrigacaoService classeObrigacaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond classeObrigacaoService.list(params), model:[classeObrigacaoCount: classeObrigacaoService.count()]
    }

    def show(Long id) {
        respond classeObrigacaoService.get(id)
    }

    def create() {
        respond new ClasseObrigacao(params)
    }

    def save(ClasseObrigacao classeObrigacao) {
        if (classeObrigacao == null) {
            notFound()
            return
        }

        try {
            classeObrigacaoService.save(classeObrigacao)
        } catch (ValidationException e) {
            respond classeObrigacao.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'classeObrigacao.label', default: 'ClasseObrigacao'), classeObrigacao.id])
                redirect classeObrigacao
            }
            '*' { respond classeObrigacao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond classeObrigacaoService.get(id)
    }

    def update(ClasseObrigacao classeObrigacao) {
        if (classeObrigacao == null) {
            notFound()
            return
        }

        try {
            classeObrigacaoService.save(classeObrigacao)
        } catch (ValidationException e) {
            respond classeObrigacao.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'classeObrigacao.label', default: 'ClasseObrigacao'), classeObrigacao.id])
                redirect classeObrigacao
            }
            '*'{ respond classeObrigacao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        classeObrigacaoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'classeObrigacao.label', default: 'ClasseObrigacao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'classeObrigacao.label', default: 'ClasseObrigacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
