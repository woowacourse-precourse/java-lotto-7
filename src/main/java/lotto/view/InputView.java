package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {
    public static int getMoneyToBuy() {
        while (true) {
            try {
                OutputView.notifyEnterMoneyToBuy();
                String input = Console.readLine();
                return MoneyValidator.validateMoneyToBuy(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                OutputView.notifyEnterWinningNumbers();
                String input = Console.readLine();
                return WinningNumbersValidator.validateWinningNumbers(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int getBonusNumber() {
        while (true) {
            try {
                OutputView.notifyEnterBonusNumber();
                String input = Console.readLine();
                return BonusNumberValidator.validateBonusNumber(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
