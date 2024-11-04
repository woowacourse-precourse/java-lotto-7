package lotto.exception;

public class NotDivisibleByLottoPriceException extends IllegalArgumentException {
	public NotDivisibleByLottoPriceException(String message) {
		super(ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue()
			+ ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE);
	}
}
