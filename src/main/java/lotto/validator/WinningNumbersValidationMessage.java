package lotto.validator;

public enum WinningNumbersValidationMessage {
	INVALID_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야 합니다."),
	INVALID_WINNING_NUMBERS_RANGE("[ERROR] 당첨 번호는 1~45 사이여야 합니다."),
	INVALID_WINNING_NUMBERS_DUPLICATION("[ERROR] 당첨 번호는 중복되지 않은 숫자여야 합니다."),
	INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1~45 사이여야 합니다."),
	INVALID_WINNING_NUMBERS_WITH_BONUS_NUMBER_DUPLICATION("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");

	private final String message;

	WinningNumbersValidationMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
