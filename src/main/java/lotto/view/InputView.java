package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        System.out.println(WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }


}
