package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.model.constant.ErrorMessage;

public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);

		this.numbers = numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> removeDuplicate = new HashSet<>(numbers);

		if (numbers.size() != removeDuplicate.size()) {
			throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
