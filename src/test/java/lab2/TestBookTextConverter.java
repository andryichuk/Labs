package lab2;

import lab2.exception.ConvertException;
import lab2.model.Book;
import lab2.converter.BookTextConverter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TestBookTextConverter {

    private BookTextConverter BookTextConverter;
    private Book book;

    {
        BookTextConverter = new BookTextConverter();
    }

    @BeforeMethod
    public void beforeMethod() {
        book = new Book.Builder()
                .title("Shine")
                .genre("horror")
                .yearOfWriting(LocalDate.of(2001,5,12))
                .yearOfPublishing(LocalDate.of(2005,1,11))
                .publishing("Sunshine")
                .build();
    }

    @Test
    public void serializeToStringTest() throws ConvertException {
        String expected = "Shine-Sunshine-2001\\-05\\-12-2005\\-01\\-11-horror";
        String actual = BookTextConverter.serializeToString(book);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deserializeStringTest() throws ConvertException {
        String serialized = "Shine-horror-2001\\-05\\-12-2005\\-01\\-11-Sunshine";
        Book actual = BookTextConverter.deserializeString(serialized);
        Assert.assertEquals(actual, book);
    }


    @DataProvider
    public Object[][] negativeDeserializeStringDataProvider() {
        return new Object[][]{
                {"235235.0-2432-Debit-USD-2454.0"},
                {"235235-2432.0-Debit-USD-2454.0"},
                {"235235-2432-Debit-2454.0"}
        };
    }

    @Test(expectedExceptions = ConvertException.class, dataProvider = "negativeDeserializeStringDataProvider")
    public void negativeDeserializeStringTest(String serializedString) throws ConvertException {
        BookTextConverter.deserializeString(serializedString);
    }
}