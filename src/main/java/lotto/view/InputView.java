package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Prompt;

public class InputView {
    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(Prompt.INPUT_MONEY.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(Prompt.INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(Prompt.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }


}
