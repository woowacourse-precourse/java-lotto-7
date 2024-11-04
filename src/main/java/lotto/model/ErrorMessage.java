package lotto.model;

public enum ErrorMessage {

	INVALID_PRICE_VALUE("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다."),
	INVALID_PRICE_AMOUNT("[ERROR] 구입금액은 0보다 커야 합니다."),
	INVALID_LOTTO_NUMBERS_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
	DUPLICATED_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복될 수 없습니다."),
	INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1 이상 45 이하이어야 합니다."),
	INVALID_PRICE_INPUT("[ERROR] 구입금액은 숫자이어야 합니다."),
	INVALID_WINNING_NUMBERS_INPUT("[ERROR] 구입금액은 숫자이어야 합니다."),
	INVALID_BONUS_NUMBER_INPUT("[ERROR] 보너스 번호는 숫자이어야 합니다.")
	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
