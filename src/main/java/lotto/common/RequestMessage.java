package lotto.common;

public enum RequestMessage {

	LOTTO_PURCHASE_AMOUNT_MESSAGE("구매금액을 입력해 주세요.");

	private final String message;

	RequestMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
