package lab3.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Author {

    private String firstname;

    private String lastname;

    private String secondname;

    private LocalDate date; // TODO LocalDate

    private Set<Book> books;

    {
        books = new HashSet<Book>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return date == author.date &&
                Objects.equals(firstname, author.firstname) &&
                Objects.equals(lastname, author.lastname) &&
                Objects.equals(secondname, author.secondname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, secondname, date);
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", date=" + date +
                ", books=" + books +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAge(LocalDate date) {
        this.date = date;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public boolean addBook(Book book) {
        books.add(book);
        return true;
    }
}
