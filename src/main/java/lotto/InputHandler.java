package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {

    public int getPurchaseAmount() {
        String input = Console.readLine();
        return LottoPurchaseValidator.validateAmount(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        return WinningNumbersValidator.validate(input);
    }
}
