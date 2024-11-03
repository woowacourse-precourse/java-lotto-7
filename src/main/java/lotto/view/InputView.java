package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String readUserMoney() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readWinningLotto() {
        System.out.print(NEW_LINE);
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.print(NEW_LINE);
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
