package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.global.message.ErrorMessage;

public class InputView {
    public static long inputNumber(String message) {
        System.out.println(message);
        String input = Console.readLine();
        validateNumberInput(input);
        return Long.parseLong(input);
    }

    private static void validateNumberInput(String input) {
        validateEmpty(input);
        validateNumeric(input);
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT);
        }
    }

    private static void validateNumeric(String inputValue) {
        try {
            long amount = Long.parseLong(inputValue);
            validateNegative(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private static void validateNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
        }
    }

    public static List<Integer> inputWinningLotto(String message) {
        System.out.println(message);
        String winningLottoInput = Console.readLine();
        validateEmpty(winningLottoInput);
        validateCommaFormat(winningLottoInput);
        return convertToNumbers(winningLottoInput);
    }

    private static List<Integer> convertToNumbers(String input) {
        List<String> numberStrings = splitInputByComma(input);
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numberStrings) {
            numbers.add(Integer.parseInt(numberStr.trim()));
        }
        return numbers;
    }

    private static void validateCommaFormat(String input) {
        List<String> numbers = splitInputByComma(input);
        validateNumberFormat(numbers);
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static void validateNumberFormat(List<String> numbers) {
        for (String number : numbers) {
            validateNumber(number.trim());
        }
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.COMMA_SEPARATED_NUMBER);
        }
    }

}
