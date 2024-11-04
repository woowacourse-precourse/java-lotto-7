package lotto.mvc.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_MSG = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.";

    public void showPurchaseAmountMsg() {
        System.out.println(PURCHASE_AMOUNT_MSG);
    }

    public void showLottoWinningNumberMsg() {
        System.out.println(LOTTO_WINNING_NUMBER_MSG);
    }

    public void showLottoBonusNumberMsg() {
        System.out.println(LOTTO_BONUS_NUMBER_MSG);
    }

    public String getUserInput() {
        return Console.readLine();
    }
}
