package lotto.exception;

import static lotto.constants.LottoConstantNumbers.*;

public enum ErrorMessage {
	INVALID_PURCHASE_AMOUNT("구입 금액은 " + LOTTO_PRICE.getValue() + " 단위의 양의 정수를 입력해야 합니다."),
	NOT_DIVISIBLE_BY_LOTTO_PRICE("구입 금액은 " + LOTTO_PRICE.getValue() + "원 단위여야 합니다."),
	MAX_PURCHASE_EXCEED("1회 최대 구매 가능 금액은 " + MAX_PURCHASE_AMOUNT.getValue() + "입니다."),
	INVALID_LOTTO_NUMBERS_COUNT("로또 번호는 " + LOTTO_NUMBERS_COUNT.getValue() + "개여야 합니다."),
	OUT_OF_RANGE_NUMBER(
		"로또 번호는 " + MIN_LOTTO_NUMBER.getValue() + "부터 " + MAX_LOTTO_NUMBER.getValue() + "까지의 범위여야 합니다."),
	DUPLICATE_NUMBER("번호는 중복될 수 없습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ErrorConstants.ERROR_MESSAGE_PREFIX.getValue() + ErrorConstants.SPACE.getValue() + message;
	}
}