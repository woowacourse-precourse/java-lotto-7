package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final int WINNING_NUMBER_COUNT = 6;
    public static int requestPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        String amount = Console.readLine();
        Console.close();
        return Integer.parseInt(amount);
    }
}
