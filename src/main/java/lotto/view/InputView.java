package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.validation.LottoValidation.*;

import java.util.List;
import java.util.function.Function;

import lotto.validation.LottoValidation;

public class InputView {

	public static int getPurchaseAmount() {
		return getInput(LottoValidation::parseAmount);
	}

	public static List<Integer> getWinningNumbers() {
		String input = readLine();
		return parseNumbers(input);
	}

	public static int getBonusNumber(List<Integer> winningNumbers) {
		return getInput(input -> parseBonusNumber(input, winningNumbers));
	}

	private static <T> T getInput(Function<String, T> parser) {
		while (true) {
			try {
				String input = readLine();
				return parser.apply(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
