package by.pivovarevich.task1.exception;

public class IncorrectInputParametersException extends Exception {

    public IncorrectInputParametersException() {
        super();
    }

    public IncorrectInputParametersException(String message) {
        super(message);
    }

    public IncorrectInputParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectInputParametersException(Throwable cause) {
        super(cause);
    }
}
