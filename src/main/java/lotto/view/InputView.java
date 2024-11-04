package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String inputBonusNumbers() {
        System.out.println(ASK_BONUS_NUMBER);
        return Console.readLine();
    }

    public static void closeConsole() {
        Console.close();
    }
}
