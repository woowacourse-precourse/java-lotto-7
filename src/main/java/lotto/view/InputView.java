package lotto.view;

import static lotto.view.constants.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.view.constants.ViewMessage.INPUT_LOTTO_PURCHASE_MONEY;
import static lotto.view.constants.ViewMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readLottoPurchaseMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY.getMessage());
        return Console.readLine();
    }

    public static String readLottoWinningNumber() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String readLottoBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
