package lab3.service;

import lab3.model.Author;
import lab3.model.Book;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class AuthorService {
    private Author author;

    public  AuthorService(Author author) {
        this.author = author;
    }

    public long countBooksGenre(String genre) {
        return author.getBooks().stream()
                .filter(c -> c.getGenre().equals(genre))
                .count();
    }

    public SortedSet<Book> sortBooksByTitle() {
        SortedSet<Book> sortedBooks = new TreeSet<>(Comparator.comparing(Book::getTitle));
        sortedBooks.addAll(author.getBooks());
        return sortedBooks;
    }


    public boolean isExistBookByPublishing(String publishing) {
        Author result = new Author();
        author.getBooks().stream()
                .filter(c -> ((Book) c).getPublishing().equalsIgnoreCase(publishing))
                .forEach(result::addBook);

        return !result.getBooks().isEmpty();
    }
}
