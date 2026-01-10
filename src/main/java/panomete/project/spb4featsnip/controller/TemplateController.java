package panomete.project.spb4featsnip.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panomete.project.spb4featsnip.common.ResponseDTO;
import panomete.project.spb4featsnip.common.ResponseStatus;

@RestController
@RequestMapping("/api/v1/template")
@Tag(name = "Template Controller", description = "Controller for template endpoints")
public class TemplateController {

    @GetMapping
    @Operation(
            summary = "Hello World Endpoint",
            description = "Returns a simple hello world message wrapped in a ResponseDTO"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful response with hello world message"
            )
    })
    public ResponseEntity<ResponseDTO<String>> helloWorld() {
        ResponseDTO<String> response = new ResponseDTO<>(
                "Spring Boot 4 Feature Snippets",
                ResponseStatus.SUCCESS,
                null
        );
        return ResponseEntity.ok(response);
    }
}
