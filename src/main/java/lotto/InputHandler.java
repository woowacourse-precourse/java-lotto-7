package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public int getPurchaseAmount() {
        String input = Console.readLine();
        return LottoPurchaseValidator.validateAmount(input);
    }
}
