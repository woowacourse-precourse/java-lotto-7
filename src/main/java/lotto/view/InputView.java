package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.util.InputHandler.*;
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
}
