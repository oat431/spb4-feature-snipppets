package panomete.project.spb4featsnip.common;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Generic response wrapper for API responses")
public record ResponseDTO<T>(
        @Schema(
                description = "Payload of the response when the request is successful",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        T data,

        @Schema(
                description = "Status of the response",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        ResponseStatus status,

        @Schema(
                description = "Details about any error that occurred during request processing",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        ResponseError error
) { }
