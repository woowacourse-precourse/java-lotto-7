package lotto.global;

public enum ErrorMessage {

	MONEY_AMOUNT_ERROR("[ERROR] 0원 이하는 입력할 수 없습니다."),
	MONEY_UNIT_ERROR("[ERROR] 1000원 단위로 입력할 수 있습니다.");

	ErrorMessage(String message) {
		this.message = message;
	}

	private final String message;

	public String getMessage(){
		return message;
	}
}
