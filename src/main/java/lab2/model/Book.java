package lab2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable {

    private String title;

    private String genre;

    private LocalDate yearOfWriting;

    private LocalDate yearOfPublishing;

    private String publishing;

    public static class Builder {
        private String title;

        private String genre;

        private LocalDate yearOfWriting;

        private LocalDate yearOfPublishing;

        private String publishing;

        public Builder title(String bookTitle) {
            this.title = bookTitle;
            return this;
        }

        public Builder genre(String bookGenre) {
            this.genre = bookGenre;
            return this;
        }

        public Builder yearOfWriting(LocalDate year) {
            this.yearOfWriting = year;
            return this;
        }

        public Builder yearOfPublishing(LocalDate year) {
            this.yearOfPublishing = year;
            return this;
        }

        public Builder publishing(String bookPublishing) {
            this.publishing = bookPublishing;
            return this;
        }

        public Book build() {
            Book book = new Book();

            book.title = this.title;

            book.genre = this.genre;

            book.yearOfWriting = this.yearOfWriting;

            book.yearOfPublishing = this.yearOfPublishing;

            book.publishing = this.publishing;

            return book;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfWriting == book.yearOfWriting &&
                yearOfPublishing == book.yearOfPublishing &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(publishing, book.publishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, yearOfWriting, yearOfPublishing, publishing);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year_of_writing=" + yearOfWriting +
                ", year_of_publishing=" + yearOfPublishing +
                ", publishing='" + publishing + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getYearOfWriting() {
        return yearOfWriting;
    }

    public LocalDate getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String getPublishing() {
        return publishing;
    }
}
