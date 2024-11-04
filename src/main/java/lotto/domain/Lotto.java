package lotto.domain;

import java.util.List;

import lotto.exception.LottoNumberSizeException;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new LottoNumberSizeException();
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}
}
