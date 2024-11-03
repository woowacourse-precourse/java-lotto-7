package lotto.common;

public enum ErrorMessage {
	ERROR_SIGN("[ERROR] "),
	OVER_FLOW_LOTTO_SIZE(ERROR_SIGN.comment+ "로또 번호는 6개여야 합니다."),
	DUPLICATION_LOTTO_NUMBERS(ERROR_SIGN.comment + "로또 번호애 중복된 숫자가 없어야합니다."),
	OVER_FLOW_LOTTO_NUMBER_RANGE(ERROR_SIGN.comment + "로또 번호는 1에서 45 사이의 숫자여야 합니다.");

	private final String comment;

	ErrorMessage(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
}
