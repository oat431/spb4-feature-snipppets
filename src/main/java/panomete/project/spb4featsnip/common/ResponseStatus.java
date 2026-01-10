package panomete.project.spb4featsnip.common;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status of the response")
public enum ResponseStatus {
    @Schema(description = "The request was successful and processed without errors")
    SUCCESS,

    @Schema(description = "The request was processed but encountered some issues")
    FAIL,

    @Schema(description = "The request could not be processed due to a critical error")
    ERROR
}
