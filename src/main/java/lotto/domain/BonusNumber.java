package lotto.domain;

import java.util.Objects;

import lotto.validator.WinningNumbersValidationMessage;

public class BonusNumber {
	private static final int MIN_NUMBER_VALUE = 1;
	private static final int MAX_NUMBER_VALUE = 45;

	private final int bonusNumber;

	public BonusNumber(int bonusNumber) {
		validateBonusNumberInRange(bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	public static BonusNumber from(int bonusNumber) {
		return new BonusNumber(bonusNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BonusNumber that = (BonusNumber)o;
		return bonusNumber == that.bonusNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(bonusNumber);
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	private void validateBonusNumberInRange(int bonusNumber) {
		if (bonusNumber < MIN_NUMBER_VALUE || bonusNumber > MAX_NUMBER_VALUE) {
			throw new IllegalArgumentException(WinningNumbersValidationMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
		}
	}
}
