package validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static constants.LottoException.*;

public class LottoValidator {
    public static boolean isNumber(String targetString) {
        try {
            Integer.parseInt(targetString);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }

    public static void isDivisibleByThousand(Integer targetInteger) {
        if (targetInteger % 1000 != 0) {
            throw new IllegalArgumentException(CAN_NOT_DIVIDE_BY_1000.getMessage());
        }
    }

    public static void isInLottoRange(Integer targetInteger) {
        if (targetInteger < 1 || targetInteger > 45) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static List<Integer> isParseableString(String targetString) {
        return Arrays.stream(targetString.split(","))
                .map(String::strip)
                .filter(s -> !s.isEmpty())
                .filter(LottoValidator::isNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void isUniqueNumbers(List<Integer> targetList) {
        Set<Integer> setList = new HashSet<>(targetList);
        if (setList.size() != targetList.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void hasSixElements(List<Integer> targetList) {
        if (targetList.size() != 6) {
            throw new IllegalArgumentException(LENGTH_IS_NOT_SIX.getMessage());
        }
    }

}
