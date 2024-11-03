package lotto.view;

import static lotto.utils.Messages.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPrice() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
