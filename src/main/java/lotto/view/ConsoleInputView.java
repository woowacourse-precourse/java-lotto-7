package lotto.view;

import static lotto.constants.PrintMessage.BONUS_NUMBER_MESSAGE;
import static lotto.constants.PrintMessage.PURCHASE_MESSAGE;
import static lotto.constants.PrintMessage.WINNING_NUMBERS_MESSAGE;
import static lotto.parse.InputParser.parseBonusNumber;
import static lotto.parse.InputParser.parsePurchaseAmount;
import static lotto.parse.InputParser.parseWinningNumber;
import static lotto.validate.Validator.validateBonusNumber;
import static lotto.validate.Validator.validatePurchaseAmount;
import static lotto.validate.Validator.validateWinningNumbers;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleInputView implements InputView {

    @Override
    public int readPurchaseAmount() throws IllegalArgumentException {
        PURCHASE_MESSAGE.display();
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return parsePurchaseAmount(purchaseAmount);
    }

    @Override
    public List<Integer> readWinningNumbers() throws IllegalArgumentException {
        WINNING_NUMBERS_MESSAGE.display();
        String winningNumbers = Console.readLine();
        validateWinningNumbers(winningNumbers);
        return parseWinningNumber(winningNumbers);
    }

    @Override
    public int readBonusNumber() {
        BONUS_NUMBER_MESSAGE.display();
        String bonusNumber = Console.readLine();
        validateBonusNumber(bonusNumber);
        return parseBonusNumber(bonusNumber);
    }
}
