package lotto.exception;

public enum ExceptionMessage {
	INVALID_PURCHASE_AMOUNT_FORMAT_INPUT("[ERROR] 구입 금액 형식이 올바르지 않습니다."),
	INVALID_PURCHASE_AMOUNT_INPUT("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다."),
	INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호의 범위는 1에서 45사이어야 합니다"),
	DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복을 허용하지 않습니다."),
	INVALID_LOTTO_AMOUNT("[ERROR] 로또 번호는 6개여야 합니다.");
	private final String message;

	ExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
