package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.ExtraText.WINNING_NUMBER_SEPARATOR;

import java.util.ArrayList;
import java.util.List;
import lotto.util.UserInputValidator;

public class ReadUserInputView {
    private static final int START_INDEX = 0;
    private static final int WINNING_NUMBERS_SIZE = 6;
    private final String SPACE = " ";
    private final String BLANK = "";

    private final UserInputValidator validator;

    public ReadUserInputView(UserInputValidator validator) {
        this.validator = validator;
    }

    public int readPurchaseAmount() {
        String userInput = readLine();
        //System.out.println(userInput);
        validator.isValidPurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }

    public List<Integer> readWinningNumbers() {
        String userInput = readLine();
        validator.isValidWinningNumbers(userInput);
        String[] split = userInput.split(WINNING_NUMBER_SEPARATOR.getText());
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = START_INDEX; i < WINNING_NUMBERS_SIZE; i++) {
            winningNumbers.add(Integer.parseInt(split[i]));
        }
        return winningNumbers;
    }

    public int readBonusNumber() {
        String userInput = readLine();
        validator.isValidBonusNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
