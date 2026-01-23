package panomete.project.spb4featsnip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import panomete.project.spb4featsnip.common.ResponseDTO;
import panomete.project.spb4featsnip.common.ResponseError;
import panomete.project.spb4featsnip.common.ResponseStatus;
import panomete.project.spb4featsnip.constant.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = PermissionDeniedException.class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ResponseDTO<String>> handleActionDeniedException(PermissionDeniedException ex) {
        ResponseError error = new ResponseError(
                HttpStatus.FORBIDDEN.value(),
                "COMMON-ERROR-403",
                ErrorMessage.PERMISSION_DENIED
        );
        ResponseDTO<String> response = new ResponseDTO<>(
                null,
                ResponseStatus.FAIL,
                error
        );
        return ResponseEntity.status(403).body(response);
    }

    @ExceptionHandler(value = OperationFailedException.class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO<String>> handleOperationFailed(OperationFailedException ex) {
        ResponseError error = new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "COMMON-ERROR-400",
                ErrorMessage.OPERATION_FAILED
        );
        ResponseDTO<String> response = new ResponseDTO<>(
                null,
                ResponseStatus.FAIL,
                error
        );
        return ResponseEntity.status(400).body(response);
    }

    @ExceptionHandler(value = ServerErrorException.class)
    @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ResponseDTO<String>> handleServerError(ServerErrorException ex) {
        ResponseError error = new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "SERVER-ON-FIRE-500",
                ErrorMessage.SERVER_ERROR
        );
        ResponseDTO<String> response = new ResponseDTO<>(
                null,
                ResponseStatus.ERROR,
                error
        );
        return ResponseEntity.status(500).body(response);
    }

}
