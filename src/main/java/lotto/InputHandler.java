package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {
    private List<Integer> winningNumbers;

    public int getPurchaseAmount() {
        String input = Console.readLine();
        return LottoPurchaseValidator.validateAmount(input);
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        winningNumbers = WinningNumbersValidator.validate(input);
        return winningNumbers;
    }

    public int getBonusNumber() {
        String input = Console.readLine();
        return BonusNumberValidator.validate(input, winningNumbers);
    }
}
