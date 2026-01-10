package panomete.project.spb4featsnip.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Feature Snippets API",
                version = "1.0",
                description = "API documentation for Feature Snippets that going to be used in other spring boot projects."
        )
)
public class OpenAPIConfig {
}
