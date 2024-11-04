package lotto.exception;

public enum ErrorConstants {
	ERROR_MESSAGE_PREFIX("[ERROR]"),
	SPACE(" ");

	private final String value;

	ErrorConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
