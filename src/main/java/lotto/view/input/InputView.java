package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LottoPurchaseValidator;

public class InputView {
    public static int inputLottoPurchase() {
        String lottoPurchase = Console.readLine();
        LottoPurchaseValidator.validate(lottoPurchase);
        return Integer.parseInt(lottoPurchase);
    }

    public static int inputWinningNumbers() {
    }

    public static int inputWinningNumber() {
    }
}
