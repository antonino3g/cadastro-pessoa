package br.com.desafio.controller;

import br.com.desafio.model.Endereco;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

    @Inject
    private PessoaService pessoaService;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        pessoas = new ArrayList<>();
        carregarPessoas();
    }

    public void salvar() {
        try {
            pessoaService.salvar(pessoa);
            pessoa = new Pessoa();
            carregarPessoas();
            System.out.println("Pessoa salva com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar pessoa: " + e.getMessage());
        }
    }

    public void editar(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void excluir(Pessoa pessoa) {
        try {
            pessoaService.excluir(pessoa.getId());
            pessoas = pessoaService.listarTodos();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Pessoa excluída com sucesso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao excluir a pessoa."));
        }
    }
    private void carregarPessoas() {
        pessoas = pessoaService.listarTodos();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
