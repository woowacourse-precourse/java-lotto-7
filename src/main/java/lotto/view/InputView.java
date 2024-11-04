package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ViewMessages.REQUIRE_BONUS_NUMBER;
import static lotto.view.ViewMessages.REQUIRE_PURCHASE_AMOUNT;
import static lotto.view.ViewMessages.REQUIRE_WINNING_NUMBERS;

public class InputView {
    public static String inputLottoPurchaseAmount() {
        System.out.println(REQUIRE_PURCHASE_AMOUNT);
        return readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(REQUIRE_WINNING_NUMBERS);
        return readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(REQUIRE_BONUS_NUMBER);
        return readLine();
    }
}