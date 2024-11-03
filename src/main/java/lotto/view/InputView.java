package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String ENTER_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ENTER_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String enterPurchaseAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT_MESSAGE);
        return readLine().strip();
    }

    public String enterWinningNumbers() {
        println();
        System.out.println(ENTER_WINNING_NUMBERS_MESSAGE);
        return readLine().strip();
    }

    public String enterBonusNumbers() {
        println();
        System.out.println(ENTER_BONUS_NUMBER_MESSAGE);
        return readLine().strip();
    }

    private void println() {
        System.out.println();
    }

}
