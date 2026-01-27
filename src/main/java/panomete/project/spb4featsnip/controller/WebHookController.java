package panomete.project.spb4featsnip.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import panomete.project.spb4featsnip.common.ResponseDTO;
import panomete.project.spb4featsnip.common.ResponseStatus;

@RestController
@RequestMapping("/api/v1/webhook")
@Tag(name = "WebHook Controller", description = "Controller for webhook endpoints")
public class WebHookController {

    @PostMapping
    @Operation(
            summary = "Webhook Endpoint",
            description = "Endpoint to handle webhook triggers"
    )
    public ResponseDTO<String> webhook() {
        return new ResponseDTO<>(
                "webhook triggered successfully",
                ResponseStatus.SUCCESS,
                null
        );
    }
}
