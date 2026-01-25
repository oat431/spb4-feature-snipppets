package panomete.project.spb4featsnip.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import panomete.project.spb4featsnip.model.Book;

import java.util.List;

@Controller
public class BookController {
    @QueryMapping
    public List<Book> getAllBooks() {
        return Book.getAllBooks();
    }
}
