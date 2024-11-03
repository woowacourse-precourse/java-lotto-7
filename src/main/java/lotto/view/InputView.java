package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
