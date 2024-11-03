package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ViewMessages.REQUIRE_BONUS_NUMBER;
import static lotto.view.ViewMessages.REQUIRE_PURCHASE_AMOUNT;
import static lotto.view.ViewMessages.REQUIRE_WINNING_NUMBERS;

public class InputView {
    public static void inputLottoPurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT);
        readLine();
    }

    public static void inputWinningNumbers() {
        System.out.println(REQUIRE_WINNING_NUMBERS);
        readLine();
    }

    public static void inputBonusNumber() {
        System.out.println(REQUIRE_BONUS_NUMBER);
        readLine();
    }
}