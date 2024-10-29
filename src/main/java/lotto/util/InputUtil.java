package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.LottoGameConfig;
import lotto.exception.custom.InputException;
import lotto.exception.LottoGameException;

import java.util.List;
import java.util.stream.Stream;

public class InputUtil {


    private InputUtil() {
    }

    public static int readInt() {
        return parseToInteger(readLine().trim());
    }

    public static List<Integer> readIntegerList() {
        String input = readLine().trim();
        validateDelimiter(input);
        return stringToIntegerList(input);
    }

    private static int parseToInteger(String input) {
        try {
            int convertedInput = Integer.parseInt(input);
            validatePositiveNumber(convertedInput);
            validateUnit(convertedInput);
            return convertedInput;
        } catch (NumberFormatException e) {
            throw new LottoGameException(InputException.INVALID_INTEGER);
        }
    }

    private static boolean validatePositiveNumber(int convertedInput) {
        if (isPositiveNumber(convertedInput)) {
            throw new LottoGameException(InputException.INVALID_INTEGER);
        }
        return true;
    }

    private static boolean isPositiveNumber(int convertedInput) {
        return convertedInput <= 0;
    }

    private static boolean validateUnit(int convertedInput) {
        if (isDevidedUnit(convertedInput)) {
            throw new LottoGameException(InputException.INVALID_UNIT);
        }
        return true;
    }

    private static boolean isDevidedUnit(int convertedInput) {
        return convertedInput % LottoGameConfig.LOTTO_PRICE_UNIT != 0;
    }

    private static void validateDelimiter(String input) {
        if (!input.contains(LottoGameConfig.DELIMITER_FOR_WINNING_NUMBER)) {
            throw new LottoGameException(InputException.INVALID_DELIMITER);
        }
    }

    private static List<Integer> stringToIntegerList(String input) {
        try {
            return Stream.of(input.split(LottoGameConfig.DELIMITER_FOR_WINNING_NUMBER))
                    .map(String::trim)
                    .filter(InputUtil::validateAnotherDelimiter)
                    .filter(InputUtil::validateHasInput)
                    .map(Integer::valueOf)
                    .filter(InputUtil::validatePositiveNumber)
                    .toList();
        } catch (NumberFormatException e) {
            throw new LottoGameException(InputException.INVALID_INTEGER);
        }
    }

    private static boolean validateAnotherDelimiter(String input) {
        if (!input.matches("[0-9,]+")) {
            throw new LottoGameException(InputException.ANOTHER_DELIMITER);
        }
        return true;
    }

    private static boolean validateHasInput(String input) {
        if (input.isBlank()) {
            throw new LottoGameException(InputException.INVALID_INPUT);
        }
        return true;
    }

    private static String readLine() {
        String input = Console.readLine().trim();
        validateHasInput(input);
        return input;
    }

}
