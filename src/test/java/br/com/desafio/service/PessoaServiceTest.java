package br.com.desafio.service;

import br.com.desafio.model.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaServiceTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private PessoaService service;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("\n\033[1;36m===== INICIANDO TESTES DE PESSOA =====\033[0m");
        emf = Persistence.createEntityManagerFactory("testePU");
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        System.out.println("\n\033[1;34m▶️  Iniciando teste: " + testInfo.getDisplayName() + "\033[0m");
        em = emf.createEntityManager();
        service = new PessoaService();
        service.setEntityManager(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
        em.close();
        System.out.println("\033[1;32m✔️  Finalizado teste: " + testInfo.getDisplayName() + "\033[0m");
    }

    @AfterAll
    public static void tearDownClass() {
        emf.close();
        System.out.println("\n\033[1;36m===== TODOS OS TESTES DE PESSOA FINALIZADOS =====\033[0m\n");
    }

    @Test
    @Order(1)
    public void salvarPessoaTeste() {
        Pessoa p = new Pessoa();
        p.setNome("Antonino Teste");
        p.setDataNascimento(LocalDate.of(1993, 5, 17));
        p.setSexo("M");

        service.salvar(p);

        assertNotNull(p.getId());
        System.out.println("\033[1;32m✅ Pessoa salva com ID: " + p.getId() + "\033[0m");
    }

    @Test
    @Order(2)
    public void buscarPessoaPorIdTeste() {
        Pessoa p = new Pessoa();
        p.setNome("Daniele");
        p.setDataNascimento(LocalDate.of(1995, 7, 14));
        p.setSexo("F");

        service.salvar(p);

        Pessoa encontrada = service.buscarPorId(p.getId());
        assertEquals("Daniele", encontrada.getNome());
        System.out.println("\033[1;32m✅ Pessoa encontrada: " + encontrada.getNome() + "\033[0m");
    }

    @Test
    @Order(3)
    public void listarPessoasTeste() {
        List<Pessoa> lista = service.listarTodos();
        assertNotNull(lista);
        System.out.println("\033[1;32m✅ Total de pessoas encontradas: " + lista.size() + "\033[0m");
    }
}
