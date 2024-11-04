package lotto.domain.exception;

public class CustomException extends IllegalArgumentException {

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
    }
}
