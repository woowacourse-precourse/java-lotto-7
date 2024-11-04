package lotto.common;

public enum ErrorMessage {
	NON_NUMERIC_INPUT("[ERROR] 입력 값은 숫자만 허용됩니다. 올바른 숫자를 입력해 주세요."),
	INVALID_AMOUNT("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다. 올바른 금액을 입력해 주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
