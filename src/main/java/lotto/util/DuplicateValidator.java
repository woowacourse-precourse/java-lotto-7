package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.exception.lottoticketexception.DuplicateException;

public class DuplicateValidator {
	public static <T> void validateNoDuplicates(List<T> numbers) {
		Set<T> uniqueNumbers = new HashSet<>(numbers);

		if (uniqueNumbers.size() != numbers.size()) {
			throw new DuplicateException();
		}
	}
}
