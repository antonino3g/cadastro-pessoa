package br.com.desafio.utils;

import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * Classe criada para saber como converter Pessoa para String e vice-versa.
 * */

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter<Pessoa> {

    @Inject
    private PessoaService pessoaService;

    @Override
    public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        return pessoaService.buscarPorId(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Pessoa pessoa) {
        return (pessoa == null || pessoa.getId() == null) ? "" : String.valueOf(pessoa.getId());
    }
}

