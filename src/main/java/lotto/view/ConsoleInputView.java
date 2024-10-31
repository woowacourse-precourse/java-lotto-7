package lotto.view;

import static lotto.constants.PrintMessage.BONUS_NUMBER_MESSAGE;
import static lotto.constants.PrintMessage.PURCHASE_MESSAGE;
import static lotto.constants.PrintMessage.WINNING_NUMBERS_MESSAGE;
import static lotto.parse.InputParser.getParsedPurchaseAmount;
import static lotto.parse.InputParser.getParsedWinningNumbers;
import static lotto.validate.PurchaseAmountValidator.validatePurchaseAmount;
import static lotto.validate.WinningNumbersValidator.validateWinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public int readPurchaseAmount() throws IllegalArgumentException {
        PURCHASE_MESSAGE.display();
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return getParsedPurchaseAmount(purchaseAmount);
    }

    @Override
    public List<Integer> readWinningNumbers() throws IllegalArgumentException {
        WINNING_NUMBERS_MESSAGE.display();
        String winningNumbers = Console.readLine();
        validateWinningNumbers(winningNumbers);
        return getParsedWinningNumbers(winningNumbers);
    }

    @Override
    public int readBonusNumber() {
        BONUS_NUMBER_MESSAGE.display();
        String bonusNumber = Console.readLine();
        return 1;
    }
}
