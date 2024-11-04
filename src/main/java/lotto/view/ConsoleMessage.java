package lotto.view;

public enum ConsoleMessage {
	;
	
	private final String message;

	ConsoleMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
