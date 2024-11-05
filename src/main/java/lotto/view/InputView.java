package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static String readPurchaseMoney() {
        System.out.println(AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusBall() {
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
        return Console.readLine();
    }
}