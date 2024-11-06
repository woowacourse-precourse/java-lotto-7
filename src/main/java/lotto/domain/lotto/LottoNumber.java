package lotto.domain.lotto;

import java.util.Objects;

import static lotto.exception.ErrorMessage.*;

public class LottoNumber {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private final int number;

	public LottoNumber(String lottoNumberInput) {
		validateNotBlank(lottoNumberInput);
		validateDigit(lottoNumberInput);

		int lottoNumber = Integer.parseInt(lottoNumberInput);
		validateRange(lottoNumber);

		this.number = lottoNumber;
	}

	private void validateNotBlank(String lottoNumberInput) {
		if (lottoNumberInput.isBlank()) {
			System.out.println(INPUT_BLANK.getMessage());
		}
	}

	private void validateDigit(String lottoNumberInput) {
		if (!isDigit(lottoNumberInput)) {
			System.out.println(INPUT_NOT_DIGIT.getMessage());
		}
	}

	private boolean isDigit(String lottoNumberInput) {
		return lottoNumberInput.chars().anyMatch(character -> !Character.isDigit(character));
	}

	private void validateRange(int lottoNumber) {
		if (isNumberOutOfRange(lottoNumber)) {
			throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
		}
	}

	private boolean isNumberOutOfRange(int lottoNumber) {
		return lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER;
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
