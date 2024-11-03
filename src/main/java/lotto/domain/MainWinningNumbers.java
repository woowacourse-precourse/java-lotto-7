package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lotto.validator.WinningNumbersValidationMessage;

public class MainWinningNumbers {
	private static final int WINNING_NUMBERS_COUNT = 6;
	private static final int MIN_NUMBER_VALUE = 1;
	private static final int MAX_NUMBER_VALUE = 45;

	private final List<Integer> mainWinningNumbers;

	private MainWinningNumbers(List<Integer> mainWinningNumbers) {
		validateNumbersSize(mainWinningNumbers);
		validateNumbersInRange(mainWinningNumbers);
		validateDuplicateNumbers(mainWinningNumbers);
		this.mainWinningNumbers = List.copyOf(mainWinningNumbers);
	}

	public static MainWinningNumbers from(List<Integer> mainWinningNumbers) {
		return new MainWinningNumbers(mainWinningNumbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MainWinningNumbers that = (MainWinningNumbers)o;
		return Objects.equals(mainWinningNumbers, that.mainWinningNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(mainWinningNumbers);
	}

	public List<Integer> getMainWinningNumbers() {
		return mainWinningNumbers;
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
}
