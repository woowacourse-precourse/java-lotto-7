package lotto.global;

public enum ErrorMessage {

	MONEY_AMOUNT_ERROR("[ERROR] 0원 이하는 입력할 수 없습니다."),
	MONEY_UNIT_ERROR("[ERROR] 1000원 단위로 입력할 수 있습니다."),
	INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1~45 까지만 가능합니다."),
	INVALID_MONEY_TYPE_ERROR("[ERROR] 숫자만 입력할 수 있습니다.");

	ErrorMessage(String message) {
		this.message = message;
	}

	private final String message;

	public String getMessage(){
		return message;
	}
}
