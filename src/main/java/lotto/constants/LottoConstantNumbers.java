package lotto.constants;

public enum LottoConstantNumbers {
	LOTTO_PRICE(1_000),
	MAX_PURCHASE_AMOUNT(100_000),
	LOTTO_NUMBERS_COUNT(6),
	MIN_LOTTO_NUMBER(1),
	MAX_LOTTO_NUMBER(45);

	private final int value;

	LottoConstantNumbers(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}