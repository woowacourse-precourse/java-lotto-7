package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST = "보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_REQUEST);
        return Console.readLine();
    }

    public String getWinningNumber() {
        System.out.println(WINNING_NUMBER_REQUEST);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST);
        return Console.readLine();
    }
}
