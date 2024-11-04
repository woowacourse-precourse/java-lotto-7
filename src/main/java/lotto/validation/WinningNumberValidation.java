package lotto.validation;

import lotto.enumValue.ExceptionMessage;
import lotto.util.ChangeDataType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidation {
    public static List<Integer> isIntegerType(String[] inputValues) {
        try {
            for (String value : inputValues) {
                CommonValidation.isIntegerType(value.strip());
            }

            return ChangeDataType.stringArrayToIntegerList(inputValues);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_INPUT_TYPE_DELIMITER.getErrorDescription());
        }
    }

    public static void number6(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_6.getErrorDescription());
        }
    }

    public static void value1to45(List<Integer> inputValues) {
        try {
            for (int value : inputValues) {
                CommonValidation.value1to45(value);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void duplicateChecker(List<Integer> inputValues) {
        Set<Integer> set = new HashSet<>(inputValues);

        if (set.size() != inputValues.size()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_DUPLICATE.getErrorDescription());
        }
    }
}
