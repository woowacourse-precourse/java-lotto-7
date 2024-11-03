package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.constants.InputError;
import lotto.constants.LottoInteger;
import lotto.constants.LottoString;
import lotto.view.ErrorPrinter;

public class WinNumberValidator {
    private static String rawWinNumber;
    private static List<Integer> WinNumbers;

    /**
     * 로또 당첨 번호의 유효성 검사를 진행한다.
     *
     * @param rawWinNumber 유효성 검사가 필요한 로또 당첨 번호
     * @return 유효한 로또 당첨 번호라면 true, 아닐 경우 false
     */

    public static boolean validate(String rawWinNumber) {
        WinNumberValidator.rawWinNumber = rawWinNumber;
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
        if (!rawWinNumber.isBlank()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WIN_NUMBER_SHOULD_EXIST);
        return false;
    }

    private static boolean hasDelimiterCountExactly() {
        if (rawWinNumber.chars()
                .filter(WinNumberValidator::isDelimiter)
                .count() == getLottoNumberCount() - 1) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WIN_NUMBER_CONTAIN_BAD_INPUT);
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
        ErrorPrinter.errorPrint(InputError.LOTTO_WIN_NUMBER_NOT_EQUAL_COUNT);
        return false;
    }

    private static String[] splitWithDelimiters() {
        return rawWinNumber.split(LottoString.DELIMITER.getValue());
    }

    private static boolean isDigit() {
        try {
            WinNumbers = Arrays.stream(splitWithDelimiters())
                    .map(Integer::parseInt)
                    .toList();
            return true;
        } catch (NumberFormatException exception) {
            ErrorPrinter.errorPrint(InputError.LOTTO_WIN_NUMBER_CONTAIN_BAD_INPUT);
        }
        return false;
    }

    private static boolean isValidRangeNumbers() {
        if (WinNumbers.stream()
                .allMatch(WinNumberValidator::isValidRange)) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WIN_NUMBER_NOT_IN_BETWEEN_START_AND_END);
        return false;
    }

    private static boolean isValidRange(int needValidating) {
        return needValidating >= LottoInteger.LOTTO_START_NUMBER.getValue()
                && needValidating <= LottoInteger.LOTTO_END_NUMBER.getValue();
    }

    private static boolean hasNoDuplication() {
        if (WinNumbers.stream().distinct().count() == WinNumbers.size()) {
            return true;
        }
        ErrorPrinter.errorPrint(InputError.LOTTO_WIN_NUMBER_NOT_DUPLICATED);
        return false;
    }
}
