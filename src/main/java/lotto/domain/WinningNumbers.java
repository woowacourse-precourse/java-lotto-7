package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.validator.WinningNumbersValidationMessage;

public class WinningNumbers {
	private static final int TOTAL_NUMBERS_COUNT = 7;

	private final MainWinningNumbers mainWinningNumbers;
	private final BonusNumber bonusNumber;

	private WinningNumbers(MainWinningNumbers mainWinningNumbers, BonusNumber bonusNumber) {
		validateWinningNumbersWithBonusNumberDuplicate(mainWinningNumbers, bonusNumber);
		this.mainWinningNumbers = mainWinningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningNumbers of(MainWinningNumbers mainWinningNumbers, BonusNumber bonusNumber) {
		return new WinningNumbers(mainWinningNumbers, bonusNumber);
	}

	public List<Integer> getMainWinningNumbers() {
		return mainWinningNumbers.getMainWinningNumbers();
	}

	public int getBonusNumber() {
		return bonusNumber.getBonusNumber();
	}

	private void validateWinningNumbersWithBonusNumberDuplicate(MainWinningNumbers mainWinningNumbers,
		BonusNumber bonusNumber) {
		Set<Integer> duplicatedNumbers = new HashSet<>(mainWinningNumbers.getMainWinningNumbers());
		duplicatedNumbers.add(bonusNumber.getBonusNumber());
		if (duplicatedNumbers.size() != TOTAL_NUMBERS_COUNT) {
			throw new IllegalArgumentException(
				WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_WITH_BONUS_NUMBER_DUPLICATION.getMessage());
		}
	}
}
