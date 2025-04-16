package br.com.desafio.controller;

import br.com.desafio.model.Endereco;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.EnderecoService;
import br.com.desafio.service.PessoaService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class EnderecoBean implements Serializable {

    private List<Endereco> enderecos;
    private Endereco enderecoSelecionado;
    private String nomePessoaFiltro;

    @Inject
    private EnderecoService enderecoService;

    @Inject
    private PessoaService pessoaService;

    @PostConstruct
    public void init() {
        enderecoSelecionado = new Endereco();
        try {
            filtrarPorNomePessoa();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filtrarPorNomePessoa() {
        if (nomePessoaFiltro != null && !nomePessoaFiltro.trim().isEmpty()) {
            enderecos = enderecoService.buscarPorNomePessoa(nomePessoaFiltro);
        } else {
            enderecos = enderecoService.listarTodos();
        }
    }

    public void salvar() {
        try {
            if (enderecoSelecionado.getPessoa() != null) {
                enderecoService.salvar(enderecoSelecionado);
                enderecoSelecionado = new Endereco();
                filtrarPorNomePessoa();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Endereço salvo com sucesso."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Selecione uma pessoa."));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar o endereço."));
        }
    }

    public void editar(Endereco endereco) {
        this.enderecoSelecionado = endereco;
    }

    public void excluir(Endereco endereco) {
        try {
            enderecoService.excluir(endereco.getId());
            filtrarPorNomePessoa();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Endereço excluído com sucesso."));
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao excluir o endereço."));
        }
    }

    public List<Pessoa> autoCompletePessoa(String query) {
        return pessoaService.listarTodos().stream()
                .filter(p -> p.getNome().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Endereco getEnderecoSelecionado() {
        return enderecoSelecionado;
    }

    public void setEnderecoSelecionado(Endereco enderecoSelecionado) {
        this.enderecoSelecionado = enderecoSelecionado;
    }

    public String getNomePessoaFiltro() {
        return nomePessoaFiltro;
    }

    public void setNomePessoaFiltro(String nomePessoaFiltro) {
        this.nomePessoaFiltro = nomePessoaFiltro;
    }

    public void novoEndereco() {
        this.enderecoSelecionado = new Endereco();
    }
}
