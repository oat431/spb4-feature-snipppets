package panomete.project.spb4featsnip.exception;

public class PermissionDeniedException extends RuntimeException {
    private String message;
    public PermissionDeniedException(String message) {
        super(message);
        this.message = message;
    }

    public PermissionDeniedException() {}
}
