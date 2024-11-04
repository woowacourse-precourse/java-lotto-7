package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_PRICE_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_REQUEST = "당첨 번호를 입력해 주세요.";

    public String promptPurchasePrice() {
        System.out.println(PURCHASE_PRICE_REQUEST);

        return Console.readLine();
    }

    public String promptWinningNumbers() {
        System.out.println(WINNING_NUMBERS_REQUEST);

        return Console.readLine();
    }
}
