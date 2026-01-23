package panomete.project.spb4featsnip.exception;

public class ServerErrorException extends RuntimeException {
    private String message;
    public ServerErrorException(String message) {
        super(message);
        this.message = message;
    }

    public ServerErrorException() {}
}
