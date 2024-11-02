package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.config.ErrorMessageConstant.NON_NUMERIC_MESSAGE;
import static lotto.util.Spliter.splitWinningNumbers;

import java.util.List;

public class InputView {
    private InputView() {
    }

    public static int getPurchase() {
        return getValidateIntegerInput();
    }

    public static int getBonusNumber() {
        return getValidateIntegerInput();
    }

    public static List<Integer> getWinningNumbers() {
        String winningNumbers = readLine();
        List<String> splitWinningNumbers = splitWinningNumbers(winningNumbers);

        for (String winningNumber : splitWinningNumbers) {
            validateNumericInput(winningNumber);
        }

        return splitWinningNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static int getValidateIntegerInput() {
        String purchase = readLine();
        validateNumericInput(purchase);
        return Integer.parseInt(purchase);
    }

    private static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }
}
