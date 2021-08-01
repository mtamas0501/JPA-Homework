package hu.ulyssys.java.course.database.task.dao;

import hu.ulyssys.java.course.database.task.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDAO {

    private static final String PERSISTENCE_UNIT = "TestPersistence";
    private EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void saveAuthor(Author author) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateAuthor(Author author) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Author> findAllAuthor() {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n", Author.class);
        return query.getResultList();
    }

    public List<Author> findByNameAuthor(String firstname) {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n where n.firstName=:firstName", Author.class);
        query.setParameter("firstName", firstname);
        return query.getResultList();
    }
}
