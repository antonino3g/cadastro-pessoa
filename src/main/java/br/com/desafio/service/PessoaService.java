package br.com.desafio.service;

import br.com.desafio.model.Pessoa;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @PersistenceContext(unitName = "producaoPU")
    private EntityManager em;

    @PostConstruct
    private void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testePU");
        em = emf.createEntityManager();
    }

    public void salvar(Pessoa pessoa) {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }

        if (pessoa.getId() == null) {
            em.persist(pessoa);
        } else {
            em.merge(pessoa);
        }

        em.getTransaction().commit();
    }

    public Pessoa buscarPorId(Long id) {
        return em.find(Pessoa.class, id);
    }

    public void excluir(Long id) {
        Pessoa pessoa = em.find(Pessoa.class, id);
        if (pessoa != null) {
            em.getTransaction().begin();
            em.remove(pessoa);
            em.getTransaction().commit();
        }
    }

    public List<Pessoa> listarTodos() {
        return em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
    }

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
