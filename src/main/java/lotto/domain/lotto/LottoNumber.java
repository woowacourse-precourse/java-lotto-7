package lotto.domain.lotto;

import java.util.Objects;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

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
			throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
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
