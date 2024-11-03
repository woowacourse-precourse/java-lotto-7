package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.model.constant.ErrorMessage;
import lotto.model.constant.Values;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);
		validateRange(numbers);

		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != Values.SIZE_OF_LOTTO) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> removeDuplicate = new HashSet<>(numbers);

		if (numbers.size() != removeDuplicate.size()) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
		}
	}

	private void validateRange(List<Integer> numbers) {
		for (int number : numbers) {
			if (number < Values.LEAST_LOTTO_NUMBER || number > Values.MOST_LOTTO_NUMBER) {
				throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR_MESSAGE);
			}
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
