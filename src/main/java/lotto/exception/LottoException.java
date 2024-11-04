package lotto.exception;

public abstract class LottoException extends RuntimeException {

	private final String ERROR_MESSAGE_PREFIX = "[ERROR]";
	private final String SPACE = " ";
	private final ErrorMessage errorMessage;

	public LottoException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	@Override
	public String getMessage() {
		return ERROR_MESSAGE_PREFIX + SPACE + super.getMessage();
	}
}