package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MONEY_INPUT_VIEW = "구입금액을 입력해 주세요.";

    private static final String WINNING_NUMBERS_INPUT_VIEW = "당첨 번호를 입력해 주세요.";

    private static final String BONUS_NUMBER_INPUT_VIEW = "보너스 번호를 입력해 주세요.";

    public static int readMoney() {
        System.out.println(MONEY_INPUT_VIEW);
        int input = Integer.parseInt(Console.readLine().trim());

        return input;
    }

    public static String readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_VIEW);
        String input = Console.readLine().trim();

        return input;
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_VIEW);
        String input = Console.readLine().trim();

        Console.close();
        return input;
    }
}
