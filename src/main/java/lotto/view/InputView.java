package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;
import lotto.message.InputMessage;
import lotto.util.Validation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static lotto.util.Validation.inputDelimiter;


public class InputView {
    public static int getPrice() {
        InputMessage.INPUT_PRICE.printMessage();
        String input = Console.readLine();
        if (!Validation.isNumberValue(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
        if (!Validation.isPositive(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PRICE_VALUE.getErrorMessage());
        }
        if(!Validation.isDivided(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PRICE_MULTIPLE.getErrorMessage());
        }
        return Integer.parseInt(input);
    }

    public static List<Integer> getWinningNumbers() {
        InputMessage.INPUT_NUMBER.printMessage();
        String input = Console.readLine();
        if (!Validation.isCorrectFormat(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_FORMAT.getErrorMessage());
        }
        List<Integer> winningNumbers = parseString(input);
        if (!Validation.isCorrectSize(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getErrorMessage());
        }
        if (!Validation.isCorrectRange(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getErrorMessage());
        }
        if (!Validation.isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_PRESENT.getErrorMessage());
        }
        return winningNumbers;
    }

    public static int getBonusNumber() {
        InputMessage.INPUT_BONUS.printMessage();

        String input = Console.readLine();
        if (!Validation.isNumberValue(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getErrorMessage());
        }
        if (!Validation.isCorrectRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getErrorMessage());
        }
        return Integer.parseInt(input);
    }

    private static List<Integer> parseString(String input) {
        String[] tokens = input.split(inputDelimiter);
        return Arrays.stream(tokens).map(Integer::parseInt).toList();
    }
}
