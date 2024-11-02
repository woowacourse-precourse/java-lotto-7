package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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
            return readWinningNumbers();
        }
    }

    private String readInput() {
        return Console.readLine();
    }
}
