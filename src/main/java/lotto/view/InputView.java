package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static String readPurchasePrice() {
        System.out.println(INPUT_BUDGET_MESSAGE);
        return Console.readLine();
    }

    public static String readWinningNumber() {
        System.out.println(INPUT_WINNING_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(INPUT_BONUS_MESSAGE);
        return Console.readLine();
    }
}
