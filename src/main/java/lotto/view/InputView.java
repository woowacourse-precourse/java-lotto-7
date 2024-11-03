package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputMoney() {
        System.out.println(InputViewConfig.GET_MONEY.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputViewConfig.GET_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputWinningBonusNumber() {
        System.out.println(InputViewConfig.GET_WINNING_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
