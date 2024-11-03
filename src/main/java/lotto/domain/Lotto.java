package lotto.domain;

import static lotto.common.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private static final int LOTTO_SIZE = 6;
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDuplicatedNumbers(numbers);
		validateNumbersRange(numbers);

		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LOTTO_SIZE) {
			throw new IllegalArgumentException(OVER_FLOW_LOTTO_SIZE.getComment());
		}
	}

	private void validateDuplicatedNumbers(List<Integer> numbers) {
		Set<Integer> numbersSet = new HashSet<>(numbers);

		if (numbersSet.size() != numbers.size()) {
			throw new IllegalArgumentException(DUPLICATION_LOTTO_NUMBERS.getComment());
		}
	}

	private void validateNumbersRange(List<Integer> numbers) {
		boolean hasOverFlowRange = numbers.stream()
			.anyMatch(number -> number < MIN_NUMBER || MAX_NUMBER < number);

		if (hasOverFlowRange) {
			throw new IllegalStateException(OVER_FLOW_LOTTO_NUMBER_RANGE.getComment());
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
