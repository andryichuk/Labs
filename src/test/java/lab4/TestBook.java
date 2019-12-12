package lab4;

import lab4.model.Book;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestBook {
    @Test(expectedExceptions = IllegalStateException.class)
    public void testBuilder() {
        Book book = new Book.Builder()
                .title("Shine")
                .genre("horror")
                .yearOfWriting(LocalDate.of(2001,5,12))
                .build();
    }

    @Test
    public void testMinBalanceValidator() {
         Book book = new Book.Builder()
                .title("Shine")
                .genre("horror")
                .yearOfWriting(LocalDate.of(2017,5,12))
                .yearOfPublishing(LocalDate.of(2019,1,11))
                .publishing("Sunshine")
                .build();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testMinBalanceValidatorNegative() {
        Book book = new Book.Builder()
                .title("Shine")
                .genre("horror")
                .yearOfWriting(LocalDate.of(2001,5,12))
                .yearOfPublishing(LocalDate.of(2005,1,11))
                .publishing("Sunshine")
                .build();
    }
}
