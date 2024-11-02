package lotto.domain;

public class LottoNumber {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private final int number;

	protected LottoNumber(int number) {
		validateNumber(number);
		this.number = number;
	}

	private void validateNumber(int number) {
		if (isNumberOutOfRange(number)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위의 정수여야 합니다.");
		}
	}

	private static boolean isNumberOutOfRange(int number) {
		return number < MIN_NUMBER || number > MAX_NUMBER;
	}

	public int getNumber() {
		return number;
	}
}
