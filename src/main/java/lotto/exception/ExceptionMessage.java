package lotto.exception;

public enum ExceptionMessage {
	NOT_EMPTY("빈 문자열은 입력할 수 없습니다."),
	NOT_NUMBER("숫자가 아닙니다.");

	private final String message;
	private static final String ERROR_PREFIX = "[ERROR] ";

	ExceptionMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return ERROR_PREFIX + message;
	}
}
