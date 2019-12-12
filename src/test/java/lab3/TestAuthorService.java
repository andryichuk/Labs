package lab3;

import lab3.model.*;
import lab3.service.AuthorService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;

public class TestAuthorService {

    private AuthorService authorService;
    private Author author;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    {
        book1 = new Book.Builder()
                .title("Shine")
                .genre("horror")
                .yearOfWriting(LocalDate.of(2003,6,20))
                .yearOfPublishing(LocalDate.of(2008,5,11))
                .publishing("Sunshine")
                .build();

        book2 = new Book.Builder()
                .title("Vunni zirku")
                .genre("drama")
                .yearOfWriting(LocalDate.of(2001,5,12))
                .yearOfPublishing(LocalDate.of(2005,1,11))
                .publishing("Sunshine")
                .build();

        book3 = new Book.Builder()
                .title("Doctor son")
                .genre("horror")
                .yearOfWriting(LocalDate.of(2001,5,12))
                .yearOfPublishing(LocalDate.of(2005,1,11))
                .publishing("eay")
                .build();

        book4 = new Book.Builder()
                .title("Haiku narnia")
                .genre("fantasy")
                .yearOfWriting(LocalDate.of(2014,5,12))
                .yearOfPublishing(LocalDate.of(2018,1,11))
                .publishing("cat")
                .build();
    }

    @BeforeMethod
    public void createAuthor() {
        author = new Author();
    }

    @BeforeMethod
    public void createAuthorService() {
        authorService = new AuthorService(author);
    }

    @Test
    public void sortBooksByTitle() {
        author.addBook(book3);
        author.addBook(book4);

        SortedSet<Book> actual = authorService.sortBooksByTitle();
        SortedSet<Book> expected = new TreeSet<>();
        expected.add(book3);
        expected.add(book4);
        Assert.assertEquals(expected, actual, "Books aren't sorted");
    }

    @Test
    public void countBooksGenreTest() {
        author.addBook(book2);
        author.addBook(book3);

        long expected = 1;
        long actual = authorService.countBooksGenre("horror");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void searchBooksByTitle() {
        author.addBook(book1);
        author.addBook(book3);

        Assert.assertTrue(authorService.isExistBookByPublishing("eay"));
    }
}