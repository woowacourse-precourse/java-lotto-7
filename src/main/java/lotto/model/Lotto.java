package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

	private static final String LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
	private static final String LOTT_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복이 불가능 합니다.";

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateSize(numbers);
		validateDuplicate(numbers);

		this.numbers = numbers;
	}

	private void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
		}
	}

	private void validateDuplicate(List<Integer> numbers) {
		Set<Integer> removeDuplicate = new HashSet<>(numbers);

		if (numbers.size() != removeDuplicate.size()) {
			throw new IllegalArgumentException(LOTT_NUMBER_DUPLICATE_ERROR_MESSAGE);
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
