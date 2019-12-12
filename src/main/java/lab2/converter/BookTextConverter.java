package lab2.converter;

import lab2.exception.ConvertException;
import lab2.model.Book;
import lab2.converter.Converter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BookTextConverter implements Converter<Book> {

    private final String FIELDS_SEPARATOR = "-";
    private final Integer FIELDS_COUNT = 5;

    private Object[] getBookFields(Book book) {
        return new Object[]{
              book.getTitle(),  book.getPublishing(), book.getYearOfWriting(), book.getYearOfPublishing(), book.getGenre()
        };
    }

    @Override
    public String serializeToString(Book book) throws ConvertException {
        try {
            Object[] bookFields = getBookFields(book);

            List<String> stringFields = Arrays.stream(bookFields)
                    .map(Object::toString)
                    .map(o -> o.replace(FIELDS_SEPARATOR, "\\" + FIELDS_SEPARATOR))
                    .collect(Collectors.toList());

            return String.join(FIELDS_SEPARATOR, stringFields);
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

    @Override
    public Book deserializeString(String serializedString) throws ConvertException {
        try {
            String[] stringFields = serializedString.split("(?<!\\\\)" + FIELDS_SEPARATOR);

            if (stringFields.length != FIELDS_COUNT) {
                throw new Exception("Invalid format of string!");
            }

            Iterator<String> fieldsIterator = Arrays.stream(stringFields).map(s -> s.replace("\\" + FIELDS_SEPARATOR, FIELDS_SEPARATOR)).iterator();

            return new Book.Builder()
                    .title(fieldsIterator.next())
                    .genre(fieldsIterator.next())
                    .yearOfWriting(LocalDate.parse(fieldsIterator.next()))
                    .yearOfPublishing(LocalDate.parse(fieldsIterator.next()))
                    .publishing(fieldsIterator.next())
                    .build();
        } catch (Exception ex) {
            throw new ConvertException(ex.getMessage());
        }
    }

}