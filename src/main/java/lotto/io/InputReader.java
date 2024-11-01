package lotto.io;

import camp.nextstep.edu.missionutils.Console;
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

    private String readInput() {
        return Console.readLine();
    }
}
