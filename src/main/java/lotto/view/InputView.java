package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_PRICE_REQUEST = "구입금액을 입력해 주세요.";

    public String promptPurchasePrice() {
        System.out.println(PURCHASE_PRICE_REQUEST);

        return Console.readLine();
    }
}
