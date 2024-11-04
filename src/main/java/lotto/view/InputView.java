package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_MSG = "구입금액을 입력 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MSG = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG = "보너스 번호를 입력해 주세요.";

    public static String inputPurchase() {
        System.out.println(INPUT_PURCHASE_MSG);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MSG);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
        return Console.readLine();
    }
}
