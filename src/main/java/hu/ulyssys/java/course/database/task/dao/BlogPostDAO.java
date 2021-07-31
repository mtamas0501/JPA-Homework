package hu.ulyssys.java.course.database.task.dao;

import hu.ulyssys.java.course.database.task.entity.Author;
import hu.ulyssys.java.course.database.task.entity.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BlogPostDAO {
    private static final String PERSISTENCE_UNIT = "TestPersistence";
    private EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void saveBlogPost(BlogPost blogPost) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateBlogPost(BlogPost blogPost) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(blogPost);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<BlogPost> findAllBlogPost() {
        TypedQuery<BlogPost> query = createEntityManager().createQuery("select n from BlogPost n", BlogPost.class);
        return query.getResultList();
    }

    public List<BlogPost> findByNameBlogPost(String content) {
        TypedQuery<BlogPost> query = createEntityManager().createQuery("select m from BlogPost m where m.content=:content", BlogPost.class);
        query.setParameter("content", content);
        return query.getResultList();
    }
}
