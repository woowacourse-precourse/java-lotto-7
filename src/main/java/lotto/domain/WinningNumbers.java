package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.validator.WinningNumbersValidationMessage;

public class WinningNumbers {

	private static final int WINNING_NUMBERS_COUNT = 6;
	private static final int MIN_NUMBER_VALUE = 1;
	private static final int MAX_NUMBER_VALUE = 45;
	private static final int TOTAL_NUMBERS_COUNT = 7;

	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	private WinningNumbers(List<Integer> numbers, int bonusNumber) {
		validateNumbersSize(numbers);
		validateNumbersInRange(numbers);
		validateDuplicateNumbers(numbers);
		validateBonusNumberInRange(bonusNumber);
		validateWinningNumbersWithBonusNumberDuplicate(numbers, bonusNumber);
		this.winningNumbers = numbers;
		this.bonusNumber = bonusNumber;
	}

	public static WinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
		return new WinningNumbers(winningNumbers, bonusNumber);
	}

	private void validateNumbersSize(List<Integer> numbers) {
		if (numbers.size() != WINNING_NUMBERS_COUNT) {
			throw new IllegalArgumentException(
				WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_SIZE.getMessage());
		}
	}

	private void validateNumbersInRange(List<Integer> numbers) {
		numbers.forEach(number -> {
			if (number < MIN_NUMBER_VALUE || number > MAX_NUMBER_VALUE) {
				throw new IllegalArgumentException(
					WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_RANGE.getMessage());
			}
		});
	}

	private void validateDuplicateNumbers(List<Integer> numbers) {
		Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
		if (duplicatedNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(
				WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_DUPLICATION.getMessage());
		}
	}

	private void validateBonusNumberInRange(int bonusNumber) {
		if (bonusNumber < MIN_NUMBER_VALUE || bonusNumber > MAX_NUMBER_VALUE) {
			throw new IllegalArgumentException(WinningNumbersValidationMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
		}
	}

	private void validateWinningNumbersWithBonusNumberDuplicate(List<Integer> numbers, int bonusNumber) {
		Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
		duplicatedNumbers.add(bonusNumber);
		if (duplicatedNumbers.size() != TOTAL_NUMBERS_COUNT) {
			throw new IllegalArgumentException(
				WinningNumbersValidationMessage.INVALID_WINNING_NUMBERS_WITH_BONUS_NUMBER_DUPLICATION.getMessage());
		}
	}
}
