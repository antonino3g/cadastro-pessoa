package br.com.desafio.utils;

import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 * Classe criada para saber como converter Pessoa para String e vice-versa.
 */

@FacesConverter(value = "br.com.desafio.utils.PessoaConverter", forClass = Pessoa.class)
public class PessoaConverter implements Converter<Pessoa> {

    private PessoaService pessoaService;

    public PessoaConverter() {
        try {
            pessoaService = CDI.current().select(PessoaService.class).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && !value.isEmpty()) {
            try {
                return pessoaService.buscarPorId(Long.valueOf(value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Pessoa pessoa) {
        if (pessoa != null && pessoa.getId() != null) {
            return pessoa.getId().toString();
        }
        return "";
    }
}


