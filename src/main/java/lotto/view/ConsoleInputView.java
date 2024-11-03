package lotto.view;

import static lotto.constants.PrintMessage.BONUS_NUMBER_MESSAGE;
import static lotto.constants.PrintMessage.PURCHASE_MESSAGE;
import static lotto.constants.PrintMessage.WINNING_NUMBERS_MESSAGE;
import static lotto.utils.InputParser.parseBonusNumber;
import static lotto.utils.InputParser.parsePurchaseAmount;
import static lotto.utils.InputParser.parseWinningNumber;
import static lotto.validate.LottoNumberValidator.validateBonusNumber;
import static lotto.validate.LottoNumberValidator.validateNumbersPattern;
import static lotto.validate.PurchaseValidator.validatePurchaseAmount;

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
        validateNumbersPattern(winningNumbers);
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
