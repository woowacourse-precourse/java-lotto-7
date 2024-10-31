package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요";

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        return Console.readLine().strip();
    }

    public String readWinningNumber() {
        System.out.println(WINNING_NUMBERS_INPUT);
        return Console.readLine().strip();
    }
}