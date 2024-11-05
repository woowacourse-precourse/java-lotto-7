package lotto.util;

import java.util.Arrays;
import java.util.List;

public class WinningNumberSeparator {

	public List<Integer> splitByComma(String input) {
		List<Integer> numbers = Arrays.stream(input.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.toList();
		return numbers;
	}
}
