package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.error.ErrorHandler;
import lotto.Validator;

public class InputReader {

    private final InputParser inputParser = new InputParser();

    public long readPurchaseAmount() {
        try {
            String input = readInput();
            long purchaseAmount = inputParser.convertStringToLong(input);
            Validator.validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            ErrorHandler.print(e.getMessage());
            return readPurchaseAmount();
        }
    }

    public List<Integer> readWinningNumbers() {
        try {
            String input = readInput();
            List<Integer> winningNumbers = inputParser.splitToInteger(input);
            Validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            ErrorHandler.print(e.getMessage());
            return readWinningNumbers();
        }
    }

    public int readBonusNumber(List<Integer> winningNumbers) {
        try {
            String input = readInput();
            int bonusNumber = inputParser.convertStringToInt(input);
            Validator.validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            ErrorHandler.print(e.getMessage());
            return readBonusNumber(winningNumbers);
        }
    }

    private String readInput() {
        String input = Console.readLine();
        Validator.validateEmptyString(input);

        return input;
    }
}
