package lotto.exception;

public enum ExceptionMessage {
	INVALID_PURCHASE_AMOUNT_INPUT("구입 금액은 1,000원 단위로 입력 받습니다.");
	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
