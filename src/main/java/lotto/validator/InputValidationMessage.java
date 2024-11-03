package lotto.validator;

public enum InputValidationMessage {
	INVALID_PURCHASE_AMOUNT_FORMAT("[ERROR] 구매 금액은 숫자여야 합니다."),
	INVALID_PURCHASE_AMOUNT_OVER_FLOW("[ERROR] 구매 금액의 최대 범위를 초과했습니다."),
	INVALID_PURCHASE_AMOUNT_NEGATIVE("[ERROR] 구매 금액은 양수여야 합니다."),
	INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구매 금액은 1000원 단위여야 합니다."),
	MISSING_WINNING_NUMBERS_DELIMITER("[ERROR] 당첨 번호에 쉼표(,)가 없습니다."),
	INVALID_WINNING_NUMBERS_FORMAT("[ERROR] 당첨 번호는 숫자여야 합니다."),
	INVALID_WINNING_NUMBERS_OVER_FLOW("[ERROR] 당첨 번호의 최대 범위를 초과했습니다."),
	INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호는 숫자여야 합니다."),
	INVALID_BONUS_NUMBER_NEGATIVE("[ERROR] 보너스 번호는 양수여야 합니다."),
	INVALID_BONUS_NUMBER_OVER_FLOW("[ERROR] 보너스 번호의 최대 범위를 초과했습니다."),
	;

	private final String message;

	InputValidationMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
