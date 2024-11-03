package lotto.common;

public enum ErrorMessage {
	ERROR_SIGN("[ERROR] "),
	OVER_FLOW_LOTTO_SIZE(ERROR_SIGN.comment+ "로또 번호는 6개여야 합니다."),
	DUPLICATION_LOTTO_NUMBERS(ERROR_SIGN.comment + "로또 번호애 중복된 숫자가 없어야합니다."),
	OVER_FLOW_LOTTO_NUMBER_RANGE(ERROR_SIGN.comment + "로또 번호는 1에서 45 사이의 숫자여야 합니다."),
	NEGATIVE_PURCHASE_AMOUNT(ERROR_SIGN.comment + "구매 금액은 자연수여야 합니다."),
	NOT_FIT_LOTTO_PRICE_UNIT_PURCHASE_AMOUNT(ERROR_SIGN.comment + "구매 금액은 로또 금액 단위만 허용 합니다.");

	private final String comment;

	ErrorMessage(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
}
