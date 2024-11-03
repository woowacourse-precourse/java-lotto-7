package lotto.common;

public enum ErrorMessage {
	ERROR_SIGN("[ERROR] "),
	OVER_FLOW_LOTTO_SIZE(ERROR_SIGN.comment+ "로또 번호는 6개여야 합니다."),
	DUPLICATION_LOTTO_NUMBERS(ERROR_SIGN.comment + "로또 번호애 중복된 숫자가 없어야합니다."),
	OVER_FLOW_LOTTO_NUMBER_RANGE(ERROR_SIGN.comment + "로또 번호는 1에서 45 사이의 숫자여야 합니다."),
	NEGATIVE_PURCHASE_AMOUNT(ERROR_SIGN.comment + "구매 금액은 자연수여야 합니다."),
	NOT_FIT_LOTTO_PRICE_UNIT_PURCHASE_AMOUNT(ERROR_SIGN.comment + "구매 금액은 로또 금액 단위만 허용 합니다."),
	OVER_FLOW_WINNING_NUMBERS_SIZE(ERROR_SIGN.comment + "당첨 번호는 6개여야 합니다."),
	DUPLICATION_WINNING_NUMBERS(ERROR_SIGN.comment + "당첨 번호에 중복된 번호가 없어야합니다."),
	OVER_FLOW_WINNING_NUMBER_RANGE(ERROR_SIGN.comment + "당첨 번호는 1에서 45 사이의 숫자여야 합니다."),
	OVER_FLOW_BONUS_NUMBER_RANGE(ERROR_SIGN.comment + "보너스 번호는 1에서 45 사이의 숫자여야 합니다."),
	DUPLICATION_BONUS_NUMBER_IN_WINNING_NUMBERS_NUMBERS(ERROR_SIGN.comment + "당첨 번호에 사용된 번호는 보너스 번호가 될 수 없습니다."),
	NOT_NATURAL_NUMBER_PURCHASE_AMOUNT(ERROR_SIGN.comment + "0을 초과한 금액만 입력가능합니다."),
	NOT_USE_DELIMITER_IN_WINNING_NUMBERS(ERROR_SIGN.comment + "당첨 번호는 지정된 구분자(,)만을 사용하여 구분해야합니다.");

	private final String comment;

	ErrorMessage(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
}
