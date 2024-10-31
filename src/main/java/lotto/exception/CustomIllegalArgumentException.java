package lotto.exception;

public class CustomIllegalArgumentException extends IllegalArgumentException {
    private CustomIllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static CustomIllegalArgumentException from(ErrorMessage errorMessage) {
        return new CustomIllegalArgumentException(errorMessage);
    }
}
