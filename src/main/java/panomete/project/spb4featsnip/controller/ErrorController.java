package panomete.project.spb4featsnip.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panomete.project.spb4featsnip.common.ResponseDTO;
import panomete.project.spb4featsnip.common.ResponseStatus;
import panomete.project.spb4featsnip.service.ErrorService;

@RestController
@RequestMapping("/api/v1/error")
@RequiredArgsConstructor
@Tag(name = "Error Controller", description = "example error controller")
public class ErrorController {

    private final ErrorService errorService;
    private final ResponseDTO<String> normalResponse = new ResponseDTO<>(
            "This response should never be returned",
            ResponseStatus.SUCCESS,
            null
    );

    @GetMapping("/action-denied")
    @Operation(
            summary = "Action Denied Endpoint",
            description = "always denies action"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "403",
                    description = "just denied the action"
            )
    })
    public ResponseEntity<ResponseDTO<String>> actionDenied() {
        errorService.actionDenied();
        return ResponseEntity.ok(normalResponse);
    }

    @GetMapping("/operation-failed")
    @Operation(
            summary = "Operation Failed Endpoint",
            description = "always fails operation"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "just failed the operation"
            )
    })
    public ResponseEntity<ResponseDTO<String>> operationFailed() {
        errorService.operationFailed();
        return ResponseEntity.ok(normalResponse);
    }

    @GetMapping("/server-error")
    @Operation(
            summary = "Server Error Endpoint",
            description = "Server error on paper not actual server error"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "500",
                    description = "internal server error occurred (not really)"
            )
    })
    public ResponseEntity<ResponseDTO<String>> serverError() {
        errorService.serverError();
        return ResponseEntity.ok(normalResponse);
    }
}
