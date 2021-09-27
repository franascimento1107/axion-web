package com.unitech.axionweb.controller;

import com.unitech.axionweb.model.TipoCentroCusto;
import com.unitech.axionweb.repository.TipoCentroCustoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/tipos")
public class TipoCentroCustoController {
    private TipoCentroCustoRepository tipoRepository;

    @Autowired
    public TipoCentroCustoController( TipoCentroCustoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @RequestMapping(value = "/{descricao}", method = RequestMethod.GET)
    public String listaLivros(@PathVariable("descricao") String descricao, Model model) {
        List<TipoCentroCusto> listaTipos = tipoRepository.findByDescricao(descricao);
        if (listaTipos != null) {
            model.addAttribute("tipos", listaTipos);
        }
        return "listaTipos";
    }

    @RequestMapping(value = "/{descricao}", method = RequestMethod.POST)
    public String adicionaTipoWithDescricao(@PathVariable("descricao") String descricao, TipoCentroCusto tipo) {
        tipo.setDescricao(descricao);
        tipoRepository.save(tipo);
        return "redirect:/{descricao}";
    }

}
