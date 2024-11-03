package lotto.view;

import static lotto.view.constants.ViewMessage.INPUT_BONUS_NUMBER;
import static lotto.view.constants.ViewMessage.INPUT_LOTTO_PURCHASE_MONEY;
import static lotto.view.constants.ViewMessage.INPUT_WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readLottoPurchaseMoney() {
        OutputView.print(INPUT_LOTTO_PURCHASE_MONEY.getMessage());
        return Console.readLine();
    }

    public static String readLottoWinningNumber() {
        OutputView.printEmptyLine();
        OutputView.print(INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String readLottoBonusNumber() {
        OutputView.printEmptyLine();
        OutputView.print(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
