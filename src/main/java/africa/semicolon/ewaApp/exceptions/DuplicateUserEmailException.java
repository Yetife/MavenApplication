package africa.semicolon.ewaApp.exceptions;

public class DuplicateUserEmailException extends EwaAppException{
    public DuplicateUserEmailException(String message) {
        super(message);
    }
}
