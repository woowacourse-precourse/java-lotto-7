package lotto.exception;

import static lotto.constants.LottoConstantNumbers.*;

public enum ErrorMessage {
	INVALID_PURCHASE_AMOUNT("구입 금액은 " + LOTTO_PRICE + " 단위의 양의 정수를 입력해야 합니다."),
	NOT_DIVISIBLE_BY_LOTTO_PRICE("구입 금액은 " + LOTTO_PRICE + "원 단위여야 합니다."),
	MAX_PURCHASE_EXCEED("1회 최대 구매 가능 금액은 " + MAX_PURCHASE_AMOUNT + "입니다."),
	INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 " + LOTTO_NUMBERS_COUNT + "개여야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}