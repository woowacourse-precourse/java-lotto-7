package lotto.Input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESAGE);
        return readLine();
    }

    public String readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return readLine();
    }

    public String readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return readLine();
    }
}
