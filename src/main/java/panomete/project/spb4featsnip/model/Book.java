package panomete.project.spb4featsnip.model;

import java.util.Arrays;
import java.util.List;

public record Book(
        String id,
        String name,
        Integer pageCount
) {
    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Harry Potter and the Philosopher's Stone", 223),
            new Book("book-2", "Moby Dick", 635),
            new Book("book-3", "Interview with the vampire", 371)
    );

    public static List<Book> getAllBooks() {
        return books;
    }
}
