package lotto.model.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.domain.Delimiter;
import lotto.model.domain.WinningNumber;

public class Parse {

	private final Delimiter delimiter;

	public Parse(Delimiter delimiter) {
		this.delimiter = delimiter;
	}

	public static int parseToInt(String money) {
		return Integer.parseInt(money);
	}

	public static List<Integer> parseToWinningNumber(String winningNumber) {
		WinningNumber.validateDelimiter(winningNumber);

		return Arrays.stream(winningNumber.split(Delimiter.COMMA.getDelimiter()))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
}
