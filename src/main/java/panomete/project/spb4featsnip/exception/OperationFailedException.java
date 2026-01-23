package panomete.project.spb4featsnip.exception;

public class OperationFailedException extends RuntimeException{
    private String message;
    public OperationFailedException(String message) {
        super(message);
        this.message = message;
    }

    public OperationFailedException() {}
}
