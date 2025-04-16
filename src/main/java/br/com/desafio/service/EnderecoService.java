package br.com.desafio.service;

import br.com.desafio.model.Endereco;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@ApplicationScoped
public class EnderecoService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EnderecoService() {
        this.emf = Persistence.createEntityManagerFactory("testePU"); // mesma string do persistence.xml
        this.em = emf.createEntityManager();
    }

    public void salvar(Endereco endereco) {
        em.getTransaction().begin();
        if (endereco.getId() == null) {
            em.persist(endereco);
        } else {
            em.merge(endereco);
        }
        em.getTransaction().commit();
    }

    public Endereco buscarPorId(Long id) {
        return em.find(Endereco.class, id);
    }

    public void excluir(Long id) {
        Endereco endereco = em.find(Endereco.class, id);
        if (endereco != null) {
            em.getTransaction().begin();
            em.remove(endereco);
            em.getTransaction().commit();
        }
    }

    public List<Endereco> listarTodos() {
        return em.createQuery("SELECT e FROM Endereco e JOIN FETCH e.pessoa", Endereco.class).getResultList();
    }

    public List<Endereco> buscarPorNomePessoa(String nome) {
        return em.createQuery("SELECT e FROM Endereco e WHERE LOWER(e.pessoa.nome) LIKE :nome", Endereco.class)
                .setParameter("nome", "%" + nome.toLowerCase() + "%")
                .getResultList();
    }
}
