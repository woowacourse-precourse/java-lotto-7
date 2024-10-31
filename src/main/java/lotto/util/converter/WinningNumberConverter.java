package lotto.util.converter;

import lotto.exception.custom.DuplicateWinningNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.Symbol.DELIMITER;

public class WinningNumberConverter {

    public static List<Integer> convertWinningNumber(String inputWinningNumber) {
        return Arrays.stream(inputWinningNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static int convertBonusNumber(String inputWinningNumber, String inputBonusNumber) {
        validateBonusNumber(inputWinningNumber, inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private static void validateBonusNumber(String inputWinningNumber, String inputBonusNumber) {
        if (isDuplicateNumber(inputWinningNumber, inputBonusNumber)) {
            throw new DuplicateWinningNumber();
        }
    }

    private static boolean isDuplicateNumber(String inputWinningNumber, String inputBonusNumber) {
        return inputWinningNumber.contains(inputBonusNumber);
    }
}
