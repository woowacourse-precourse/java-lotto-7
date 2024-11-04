package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;
import lotto.message.InputMessage;
import lotto.util.Validation;

import java.util.Arrays;
import java.util.List;


public class InputView {

    private static final String winningNumberDelimiter = ",";

    public static int getPrice() {
        InputMessage.PRICE_PROMPT.printMessage();
        String input = Console.readLine();
        if (!Validation.isNumberValue(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
        int price = Integer.parseInt(input);
        if (!Validation.isPositive(price)) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PRICE_VALUE.getErrorMessage());
        }
        return price;
    }

    public static List<Integer> getWinningNumbers() {
        InputMessage.WINNING_NUMBER_PROMPT.printMessage();

        String input = Console.readLine();
        if (!hasCorrectFormat(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.getErrorMessage());
        }
        return parseString(input);
    }

    public static int getBonusNumber() {
        InputMessage.BONUS_NUMBER_PROMPT.printMessage();

        String input = Console.readLine();
        if (!Validation.isNumberValue(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
        int number = Integer.parseInt(input);
        if (!Validation.isCorrectRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getErrorMessage());
        }
        return number;
    }

    private static boolean hasCorrectFormat(String input) {
        String[] tokens = input.split(winningNumberDelimiter);

        return Arrays.stream(tokens).allMatch(Validation::isNumberValue);
    }

    private static List<Integer> parseString(String input) {
        String[] tokens = input.split(winningNumberDelimiter);

        try {
            return Arrays.stream(tokens).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
    }
}
