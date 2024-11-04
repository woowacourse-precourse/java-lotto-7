package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {
    public static int getMoneyToBuy() {
        OutputView.notifyEnterMoneyToBuy();
        String input = Console.readLine();
        try {
            return MoneyValidator.validateMoneyToBuy(input);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getMoneyToBuy();
        }
    }

    public static List<Integer> getWinningNumbers() {
        OutputView.notifyEnterWinningNumbers();
        String input = Console.readLine();
        try {

            return WinningNumbersValidator.validateWinningNumbers(input);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getWinningNumbers();
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        OutputView.notifyEnterBonusNumber();
        String input = Console.readLine();
        try {

            return BonusNumberValidator.validateBonusNumber(input, winningNumbers);
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
