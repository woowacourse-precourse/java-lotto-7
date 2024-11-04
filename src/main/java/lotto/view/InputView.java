package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringParser;


public class InputView {
    private static final String MONEY_INPUT = "구입 금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해 주세요.";

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static String moneyInput() {
        return input(MONEY_INPUT);
    }

    private static String winningNumbersInput() {
        return input(WINNING_NUMBERS_INPUT);
    }

    private static String bonusNumberInput() {
        return input(BONUS_NUMBER_INPUT);
    }

    public static int getMoney() {
        while (true) {
            String inputMoney = InputView.moneyInput();
            try {
                return StringParser.parseStringToInt(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
