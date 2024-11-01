package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String ANSWER_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

	public static String readPurchaseAmount() {
		System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
		return Console.readLine();
	}

	public static String readAnswerLotto() {
		System.out.println(ANSWER_LOTTO_INPUT_MESSAGE);
		return Console.readLine();; 
	}
}
