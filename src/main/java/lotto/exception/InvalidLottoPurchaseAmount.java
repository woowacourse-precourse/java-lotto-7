package lotto.exception;

public class InvalidLottoPurchaseAmount extends GeneralException {

    public InvalidLottoPurchaseAmount(final ErrorType errorType) {
        super(errorType);
    }
}
