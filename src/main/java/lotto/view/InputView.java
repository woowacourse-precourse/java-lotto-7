package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return readLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return readLine();
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}
