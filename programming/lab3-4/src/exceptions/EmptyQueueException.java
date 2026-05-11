package exceptions;

public class EmptyQueueException extends RuntimeException{
    public EmptyQueueException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        String yellowColor = "\u001B[33m";
        String resetColor = "\u001B[0m";
        return yellowColor + super.getMessage() + resetColor;
    }
}
