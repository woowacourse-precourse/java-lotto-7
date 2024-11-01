package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.constants.InputError;
import lotto.constants.LottoInteger;
import lotto.constants.LottoString;
import lotto.view.ErrorPrinter;

public class WinningNumberValidator {
    private static String rawWinningNumber;
    private static List<Integer> WinningNumbers;

    public static boolean validate(String rawWinningNumber) {
        WinningNumberValidator.rawWinningNumber = rawWinningNumber;
        if (!isExist()) {
            return false;
        }
        if (!hasDelimiterCountExactly()) {
            return false;
        }
        if (!hasNumberCountExactly()) {
            return false;
        }
        if (!isDigit()) {
            return false;
        }
        if (!isValidRangeNumbers()) {
            return false;
        }
        if (!hasNoDuplication()) {
            return false;
        }
        return true;
    }

    private static boolean isExist() {
        if (!rawWinningNumber.isBlank()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WINNING_NUMBER_SHOULD_EXIST);
        return false;
    }

    private static boolean hasDelimiterCountExactly() {
        if (rawWinningNumber.chars()
                .filter(WinningNumberValidator::isDelimiter)
                .count() == getLottoNumberCount() - 1) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WINNING_NUMBER_CONTAIN_BAD_INPUT);
        return false;
    }

    private static int getLottoNumberCount() {
        return LottoInteger.LOTTO_NUMBER_COUNT.getValue();
    }

    private static boolean isDelimiter(int it) {
        return LottoString.DELIMITER.getValue().contains(String.valueOf((char) it));
    }

    private static boolean hasNumberCountExactly() {
        String[] split = splitWithDelimiters();
        if (split.length == LottoInteger.LOTTO_NUMBER_COUNT.getValue()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WINNING_NUMBER_NOT_EQUAL_COUNT);
        return false;
    }

    private static String[] splitWithDelimiters() {
        return rawWinningNumber.split(LottoString.DELIMITER.getValue());
    }

    private static boolean isDigit() {
        try {
            WinningNumbers = Arrays.stream(splitWithDelimiters())
                    .map(Integer::parseInt)
                    .toList();
            return true;
        } catch (NumberFormatException exception) {
            ErrorPrinter.errorPrint(InputError.LOTTO_WINNING_NUMBER_CONTAIN_BAD_INPUT);
        }
        return false;
    }

    private static boolean isValidRangeNumbers() {
        if (WinningNumbers.stream()
                .allMatch(WinningNumberValidator::isValidRange)) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WINNING_NUMBER_NOT_IN_BETWEEN_START_AND_END);
        return false;
    }

    private static boolean isValidRange(int needValidating) {
        return needValidating >= LottoInteger.LOTTO_START_NUMBER.getValue()
                && needValidating <= LottoInteger.LOTTO_END_NUMBER.getValue();
    }

    private static boolean hasNoDuplication() {
        if (WinningNumbers.stream().distinct().count() == WinningNumbers.size()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WINNING_NUMBER_NOT_DUPLICATED);
        return false;
    }
}
