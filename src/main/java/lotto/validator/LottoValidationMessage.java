package lotto.validator;

public enum LottoValidationMessage {
	INVALID_LOTTO_NUMBERS_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
	INVALID_LOTTO_NUMBERS_RANGE("[ERROR] 로또 번호는 1~45 사이여야 합니다."),
	INVALID_LOTTO_NUMBERS_DUPLICATION("[ERROR] 로또 번호는 중복되지 않은 숫자여야 합니다."),
	;

	private final String message;

	LottoValidationMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
