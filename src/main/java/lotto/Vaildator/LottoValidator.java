package lotto.Vaildator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.ErrorMessage;

public class LottoValidator {

    public static void valid(List<Integer> numbers) {
        validEmpty(numbers);
        validSize(numbers);
        validNum(numbers);
        validRange(numbers);
        isDuplicate(numbers);
    }

    private static void validNum(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number == null) { // null 체크
                ErrorMessage.printError(ErrorMessage.NON_NUMERIC_ERROR);
                throw new NumberFormatException(ErrorMessage.NON_NUMERIC_ERROR);
            }
        }
    }

    private static void validSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorMessage.printError(ErrorMessage.SIZE_ERROR);
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR);
        }
    }

    private static void validEmpty(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            ErrorMessage.printError(ErrorMessage.EMPTY_VALUE_ERROR);
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE_ERROR);
        }
    }

    private static void validRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                ErrorMessage.printError(ErrorMessage.RANGE_ERROR);
                throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR);
            }
        }
    }

    public static void isDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        boolean duple = numberSet.size() < numbers.size();

        if (duple) {
            ErrorMessage.printError(ErrorMessage.NUMBER_DUPLICATE_ERROR); // 메시지 출력
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERROR); // 예외 발생
        }
    }

}
