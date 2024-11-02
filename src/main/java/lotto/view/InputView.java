package lotto.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static lotto.exception.Exception.*;
import static lotto.validator.LottoNumbersValidator.*;

import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static int inputPurchaseAmount() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_PURCHASE_AMOUNT.getMessage());
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String input = readLine();
        List<Integer> numbers = parseToInteger(splitWinningNumbers(removeAllSpaces(input)));
        validate(numbers);
        return numbers;
    }

    private static String removeAllSpaces(String input) {
        return input.replace(" ", "");
    }

    private static String[] splitWinningNumbers(String input) {
        return input.split(WINNING_NUMBER_DELIMITER);
    }

    private static List<Integer> parseToInteger(String[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_WINNING_NUMBERS.getMessage());
        }
    }
}
