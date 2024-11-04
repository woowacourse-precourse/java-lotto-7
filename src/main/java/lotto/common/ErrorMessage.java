package lotto.common;

public enum ErrorMessage {
	NON_NUMERIC_INPUT("입력 값은 숫자만 허용됩니다. 올바른 숫자를 입력해 주세요."),
	INVALID_AMOUNT("로또 구입 금액은 1,000원 단위로 입력해야 합니다. 올바른 금액을 입력해 주세요."),
	NUMBER_OUT_OF_RANGE("숫자는 {0}부터 {1} 사이의 숫자여야 합니다."),
	DUPLICATE_NUMBERS("로또 번호는 {0}개의 고유한 숫자여야 합니다."),
	BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다.");;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return "[ERROR] " + message;
	}
}
