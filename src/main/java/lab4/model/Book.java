package lab4.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lab4.validation.NotMoreThanYears;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.io.Serializable;
import java.util.Set;

@JsonDeserialize(builder = Book.Builder.class)
public class Book implements Serializable {

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String title;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String genre;

    @NotNull(message = "can't be null")
    @NotMoreThanYears(value = 5, message = "can't be more than 5 years")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate yearOfWriting;

    @NotNull(message = "can't be null")
    @NotMoreThanYears(value = 5, message = "can't be more than 3 years")
    @JsonSerialize(using = ToStringSerializer.class)
    private LocalDate yearOfPublishing;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private String publishing;

    private Book() {}

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

    public static class Builder {
        Book book;

        public Builder() {
            book = new Book();
        }

        public Builder title(String bookTitle) {
            book.title = bookTitle;
            return this;
        }

        public Builder genre(String bookGenre) {
            book.genre = bookGenre;
            return this;
        }

        public Builder yearOfWriting(LocalDate year) {
            book.yearOfWriting = year;
            return this;
        }

        public Builder yearOfPublishing(LocalDate year) {
            book.yearOfPublishing = year;
            return this;
        }

        public Builder publishing(String bookPublishing) {
            book.publishing = bookPublishing;
            return this;
        }

        public Book build() throws IllegalStateException {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

            if (constraintViolations.size() > 0) {
                Set<String> exceptionDetails = new HashSet<>();
                for (ConstraintViolation<Book> violation : constraintViolations) {
                    exceptionDetails.add(violation.getPropertyPath().toString() + " " + violation.getMessage());
                }
                throw new IllegalStateException(exceptionDetails.toString());
            }
            return book;
        }
    }
}
