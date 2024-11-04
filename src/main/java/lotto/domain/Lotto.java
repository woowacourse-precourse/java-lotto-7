package lotto.domain;

import static lotto.constants.LottoConstantNumbers.*;

import java.util.List;

import lotto.exception.lottoticketexception.DuplicateException;
import lotto.exception.lottoticketexception.LottoNumberSizeException;
import lotto.exception.numberexception.OutOfRangeNumberException;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validateNumbers(numbers);
		this.numbers = numbers;
	}

	private void validateNumbers(List<Integer> numbers) {
		validateNumbersCount(numbers);
		validateNumberRange(numbers);
		validateNoDuplicates(numbers);
	}

	private void validateNumbersCount(List<Integer> numbers) {
		if (numbers.size() != LOTTO_NUMBERS_COUNT.getValue()) {
			throw new LottoNumberSizeException();
		}
	}

	private void validateNumberRange(List<Integer> numbers) {
		for (Integer number : numbers) {
			if (number < MIN_LOTTO_NUMBER.getValue() || MAX_LOTTO_NUMBER.getValue() < number) {
				throw new OutOfRangeNumberException();
			}
		}
	}

	private void validateNoDuplicates(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != numbers.size()) {
			throw new DuplicateException();
		}
	}

	@Override
	public String toString() {
		return numbers.toString();
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
