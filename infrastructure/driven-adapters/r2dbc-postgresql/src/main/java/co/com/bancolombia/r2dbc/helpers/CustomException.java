package co.com.bancolombia.r2dbc.helpers;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
