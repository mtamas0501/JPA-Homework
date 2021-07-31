package hu.ulyssys.java.course.database.task;

import hu.ulyssys.java.course.database.task.dao.AuthorDAO;
import hu.ulyssys.java.course.database.task.dao.BlogPostDAO;
import hu.ulyssys.java.course.database.task.entity.Author;
import hu.ulyssys.java.course.database.task.entity.BlogPost;

import java.util.Date;

public class JPAMain {
    public static void main(String[] args) {
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = new Author();
        author.setFirstName("Teszt");
        author.setLastName("Jakab");
        author.setUsername("teszt username");
        author.setCreatedDate(new Date());
        author.setLastModifiedDate(new Date());
        authorDAO.saveAuthor(author);
        authorDAO.findAllAuthor().forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getFirstName() + " " + author1.getLastName() + " " + author1.getUsername());
        });
        authorDAO.findByNameAuthor("Teszt").forEach(author1 -> {
            author1.setFirstName("changed"+System.currentTimeMillis());
            authorDAO.updateAuthor(author1);
        });
        authorDAO.findAllAuthor().forEach(author1 -> {
            System.out.println(author1.getId() + " " + author1.getFirstName() + " " + author1.getLastName());
        });

        BlogPostDAO blogPostDAO = new BlogPostDAO();
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle("Teszt cim");
        blogPost.setContent("Teszt tartalom");
        blogPost.setCategory("teszt kategoria");
        blogPost.setCreatedDate(new Date());
        blogPost.setLastModifiedDate(new Date());
        blogPost.setPublishedDate(new Date());
        blogPostDAO.saveBlogPost(blogPost);

        blogPostDAO.findAllBlogPost().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getTitle() + " " + blogPost1.getContent() + " " + blogPost1.getCategory());
        });

        blogPostDAO.findByNameBlogPost("Teszt").forEach(blogPost1 -> {
            blogPost1.setTitle("changed"+System.currentTimeMillis());
            blogPostDAO.updateBlogPost(blogPost1);
        });

        blogPostDAO.findAllBlogPost().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getTitle() + " " + blogPost1.getContent() + " " + blogPost1.getCategory());
        });
    }
}
