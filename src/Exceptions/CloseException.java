package Exceptions;

public class CloseException extends Exception {
    public CloseException() {
        super("Shutdown...");
    }
}
