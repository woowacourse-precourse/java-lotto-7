package lotto.exception;

public class BuyingAmountOutOfBoundsException extends CustomException {
    private static final String MESSAGE = "구입 금액이 허용 범위를 벗어납니다. 1000원 이상 10만원 이하로만 구입 가능합니다.";

    public BuyingAmountOutOfBoundsException() {
        super(MESSAGE);
    }
}
