package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private final int number;

	public LottoNumber(int number) {
		validate(number);
		this.number = number;
	}

	private void validate(int number) {
		if (isNumberOutOfRange(number)) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위의 정수여야 합니다.");
		}
	}

	private boolean isNumberOutOfRange(int number) {
		return number < MIN_NUMBER || number > MAX_NUMBER;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LottoNumber that = (LottoNumber) o;
		return getNumber() == that.getNumber();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getNumber());
	}
}
