package lotto.io;

import static lotto.exception.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String ANSWER_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_LOTTO_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

	private static int validateLottoPurchaseAmountFormat(String lottoPurchaseAmount) {
		try {
			return Integer.parseInt(lottoPurchaseAmount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_FORMAT_INPUT.getMessage());
		}
	}

	public static int readPurchaseAmount() {
		while (true) {
			try {
				System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
				return validateLottoPurchaseAmountFormat(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}



	public static String readAnswerLotto() {
		System.out.println(ANSWER_LOTTO_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String readBonusLotto() {
		System.out.println(BONUS_LOTTO_INPUT_MESSAGE);
		return Console.readLine(); 
	}
}
