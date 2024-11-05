package lotto.service;

import java.util.List;

import static lotto.constants.Constants.*;

public class LottoValidator {

	public static void judgement(List<Integer> numbers) {
		judgementNumberSize(numbers);
		judgementRange(numbers);
		judgementDuplicate(numbers);
	}

	private static void judgementRange(List<Integer> numbers) {
		if (numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)) {
			throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
		}
	}

	private static void judgementDuplicate(List<Integer> numbers) {
		if (numbers.stream().distinct().count() != numbers.size()) {
			throw new IllegalArgumentException(LOTTO_DUPLICATE_NUMBER_ERROR);
		}
	}

	private static void judgementNumberSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
		}
	}
}
