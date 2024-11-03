package lotto.domain;

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

	public int getBonusNumber() {
		return bonusNumber;
	}

	private void validateBonusNumberInRange(int bonusNumber) {
		if (bonusNumber < MIN_NUMBER_VALUE || bonusNumber > MAX_NUMBER_VALUE) {
			throw new IllegalArgumentException(WinningNumbersValidationMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
		}
	}
}
