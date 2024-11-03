package lotto.domain;

import static lotto.common.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		validateDuplicatedNumbers(numbers);
		validateNumbersRange(numbers);

		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != LottoInfo.SIZE.getInfo()) {
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
			.anyMatch(number -> number < LottoInfo.MIN_NUMBER.getInfo() || LottoInfo.MAX_NUMBER.getInfo() < number);

		if (hasOverFlowRange) {
			throw new IllegalStateException(OVER_FLOW_LOTTO_NUMBER_RANGE.getComment());
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
