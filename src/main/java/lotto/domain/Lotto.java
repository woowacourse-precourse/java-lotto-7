package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import lotto.validator.LottoValidationMessage;

public class Lotto {
	private static final int MIN_NUMBER_VALUE = 1;
	private static final int MAX_NUMBER_VALUE = 45;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
		validateDuplicateNumbers(numbers);
		validateNumbersInRange(numbers);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lotto lotto = (Lotto)o;
		return Objects.equals(numbers, lotto.numbers);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(numbers);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getMatchCount(List<Integer> winningNumbers) {
		List<Integer> retain = new ArrayList<>(numbers);
		retain.retainAll(winningNumbers);
		return retain.size();
	}

	public boolean getMatchBonus(int bonusNumber) {
		return numbers.contains(bonusNumber);
	}

	private void validateDuplicateNumbers(List<Integer> numbers) {
		Set<Integer> duplicatedNumbers = new HashSet<>(numbers);
		if (duplicatedNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(
				LottoValidationMessage.INVALID_LOTTO_NUMBERS_DUPLICATION.getMessage());
		}
	}

	private void validateNumbersInRange(List<Integer> numbers) {
		numbers.forEach(number -> {
			if (number < MIN_NUMBER_VALUE || number > MAX_NUMBER_VALUE) {
				throw new IllegalArgumentException(
					LottoValidationMessage.INVALID_LOTTO_NUMBERS_RANGE.getMessage());
			}
		});
	}
}
