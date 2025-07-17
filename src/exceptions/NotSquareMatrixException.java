package exceptions;

public class NotSquareMatrixException extends Exception{
    public NotSquareMatrixException() {
        super("Row not equal to column.\nEnter again:");
    }
}
