package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.ExtraText.WINNING_NUMBER_SEPARATOR;

import lotto.util.UserInputValidator;

public class ReadUserInputView {
    private UserInputValidator validator;
    private static final int START_INDEX = 0;
    private static final int WINNING_NUMBERS_SIZE = 6;

    public ReadUserInputView(UserInputValidator validator) {
        this.validator = validator;
    }

    public int readPurchaseAmount() {
        String userInput = readLine();
        validator.isValidPurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public int[] readWinningNumbers() {
        String[] userInput = readLine().split(WINNING_NUMBER_SEPARATOR.getText());
        validator.isValidWinningNumbers(userInput);
        int[] winningNumbers = new int[WINNING_NUMBERS_SIZE];
        for (int i = START_INDEX; i < WINNING_NUMBERS_SIZE; i++) {
            winningNumbers[i] = Integer.parseInt(userInput[i]);
        }
        return winningNumbers;
    }

    public int readBonusNumber() {
        String userInput = readLine();
        validator.isValidBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
