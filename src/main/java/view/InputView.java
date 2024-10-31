package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MSG);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MSG);
        return Console.readLine();
    }
}
