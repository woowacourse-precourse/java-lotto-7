package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constants;

public class InputView {
    public static String inputAmountOfLotto() {
        System.out.println(Constants.LOTTO_AMOUNT_INPUT);
        return Console.readLine();
    }

    public static String inputWinningNums() {
        System.out.println(Constants.LOTTO_WINNING_NUMS_INPUT);
        return Console.readLine();
    }

    public static String inputBonusNum() {
        System.out.println(Constants.BONUS_NUM_INPUT);
        return Console.readLine();
    }
}
