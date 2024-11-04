package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String enterPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);

        return Console.readLine();
    }

    public String enterWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        return Console.readLine();
    }

    public String enterBonsuNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        return Console.readLine();
    }
}