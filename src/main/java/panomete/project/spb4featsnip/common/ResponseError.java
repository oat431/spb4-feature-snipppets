package panomete.project.spb4featsnip.common;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Details about an error that occurred during request processing")
public record ResponseError(
        @Schema(
                description = "HTTP status code associated with the error",
                example = "404",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Integer httpCode,

        @Schema(
                description = "Application-specific error code",
                example = "ITEM-400",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String errorCode,

        @Schema(
                description = "Human-readable message describing the error",
                example = "Item not found",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String message
) { }
