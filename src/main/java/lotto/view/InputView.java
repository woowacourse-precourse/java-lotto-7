package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHASE_PRICE = "구입금액을 입력해 주세요.";

    public static String askPurchasePrice() {
        System.out.println(ASK_PURCHASE_PRICE);
        return Console.readLine();
    }
}
