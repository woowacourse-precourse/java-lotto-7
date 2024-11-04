package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_PURCHASE_MONEY_MESSAGE_STRING = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE_STRING = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE_STRING = "보너스 번호를 입력해 주세요.";

    public static String readPurchaseMoney() {
        System.out.println(ASK_PURCHASE_MONEY_MESSAGE_STRING);
        return Console.readLine();        
    }

    public static String readWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS_MESSAGE_STRING);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE_STRING);
        return Console.readLine();
    }
}
