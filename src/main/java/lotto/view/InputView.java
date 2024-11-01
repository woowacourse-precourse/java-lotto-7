package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

	private static String readInput(String message) {
		System.out.println(message);
		String input = Console.readLine();
		return input;
	}

	public static String inputPurchasePrice() {
		return readInput(PURCHASE_PRICE_MESSAGE);
	}

	public static String inputWinningNumbers() {
		return readInput(WINNING_NUMBERS_MESSAGE);
	}

	public static String inputBonusNumber() {
		return readInput(BONUS_NUMBER_MESSAGE);
	}
}
