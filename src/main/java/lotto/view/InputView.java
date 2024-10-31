package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String getRequestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE);
        return Console.readLine();
    }

    public String getRequestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        return Console.readLine();
    }

    public String getRequestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
