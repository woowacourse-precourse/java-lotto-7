package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_INPUT = "보너스 번호를 입력해 주세요.";

    public String purchaseInput() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String winningNumberInput() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String bonusInput() {
        System.out.println();
        System.out.println(INPUT_BONUS_INPUT);
        return Console.readLine();
    }
}
