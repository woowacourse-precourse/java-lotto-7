package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_MSG = "구입금액을 입력 주세요.";

    public static String inputPurchase() {
        System.out.println(INPUT_PURCHASE_MSG);
        return Console.readLine();
    }
}
