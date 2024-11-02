package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_USER_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String readUserNumber() {
        System.out.println(REQUEST_USER_NUMBER);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
