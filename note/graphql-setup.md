# Setup Graphql with Spring Boot

offical doc: [spb_w_gql](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)

## Step 1: Add dependencies

``` groovy
    implementation 'org.springframework.boot:spring-boot-starter-graphql:4.0.2'
```

## Step 2: Create GraphQL schema

Create a file named `<entity>.graphqls` in the `src/main/resources/graphql` directory.
``` graphql
type Book {
    id: ID
    name: String
    pageCount: Int
}
```

then create a `endpoint.graphqls` for query and mutation
``` graphql
type Query {
    getAllBooks: [Book]
}
```

## Step 3: Create Data Fetcher
Create model class for Entity so java can map the data
``` java
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
```

Then create a controller to handle the query
``` java
@Controller
public class BookController {
    @QueryMapping
    public List<Book> getAllBooks() {
        return Book.getAllBooks();
    }
}
```

## Step 4: Test the GraphQL API
config the application.yml to enable the GraphQL playground
``` yaml
spring:
  graphql:
    graphiql:
      enabled: true
      path: /api-graph # default is /graphiql
```

Run the Spring Boot application and navigate to `http://localhost:8080/api-graph` to access the GraphiQL interface. You can test your query like this:
``` graphql
query {
    getAllBooks {
        id
        name
        pageCount
    }
}
```

that 's it! You have successfully set up GraphQL with Spring Boot.
