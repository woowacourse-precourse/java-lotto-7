package lotto.validator;

public enum LottoValidationMessage {
	INVALID_PURCHASE_AMOUNT_FORMAT("[ERROR] 구매 금액은 숫자여야 합니다."),
	INVALID_PURCHASE_AMOUNT_NEGATIVE("[ERROR] 구매 금액은 양수여야 합니다."),
	INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구매 금액은 1000원 단위여야 합니다."),
	MISSING_WINNING_NUMBERS_DELIMITER("[ERROR] 당첨 번호에 쉼표(,)가 없습니다."),
	INVALID_WINNING_NUMBERS_FORMAT("[ERROR] 당첨 번호는 숫자여야 합니다."),
	INVALID_WINNING_NUMBERS_SIZE("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야 합니다."),
	INVALID_WINNING_NUMBERS_RANGE("[ERROR] 당첨 번호는 1~45 사이여야 합니다."),
	INVALID_WINNING_NUMBERS_DUPLICATION("[ERROR] 당첨 번호는 중복되지 않은 숫자여야 합니다."),
	INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호는 숫자여야 합니다."),
	INVALID_BONUS_NUMBER_NEGATIVE("[ERROR] 보너스 번호는 양수여야 합니다."),
	INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");

	private final String message;

	LottoValidationMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
