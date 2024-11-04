package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_LOTTO_PURCHASE_AMOUNT = "구매금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(REQUEST_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(REQUEST_LOTTO_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_NUMBER);
        return Console.readLine();
    }
}
