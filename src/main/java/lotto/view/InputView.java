package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.validation.LottoValidation.*;

import java.util.List;

public class InputView {

	public static int getPurchaseAmount() {
		while (true) {
			try {
				String input = readLine();
				return parseAmount(input);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static List<Integer> getWinningNumbers() {
		String input = readLine();
		return parseNumbers(input);
	}

	public static int getBonusNumber(List<Integer> winningNumbers) {
		while (true) {
			try {
				String input = readLine();
				return parseBonusNumber(input, winningNumbers);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
