package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.validator.BonusValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumbersValidator;

public class InputView {
    private static String readInput() {
        return Console.readLine();
    }

    public static int readPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmountValidator.validate(readInput());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumbers() {
        while (true) {
            try {
                return WinningNumbersValidator.validate(readInput());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int readBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return BonusValidator.validate(readInput(), winningLotto);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
