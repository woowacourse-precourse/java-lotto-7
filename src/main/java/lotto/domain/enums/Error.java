package lotto.domain.enums;

public enum Error {

	INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
	INVALID_AMOUNT("구입 금액은 1,000원 단위여야 합니다."),
	INVALID_WINNING_NUMBER("당첨 번호는 6개여야 합니다."),
	INVALID_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
	DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
	DUPLICATE_LOTTO_NUMBER("당첨번호는 중복되지 않아야 합니다.");

	private static final String PREFIX = "[ERROR] ";

	private final String message;

	Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return PREFIX + message;
	}
}
