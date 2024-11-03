package lotto.util;

import lotto.exception.ErrorMessages;

import java.util.List;
import java.util.Set;

public class LottoValidate {

    public static void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicate(numbers);
    }

    // 로또 개수 검사
    private static void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_SIZE.getMessage());
        }
    }

    // 로또 중복 검사
    private static void checkDuplicate(List<Integer> numbers) {
        Set<Integer> eliminateDuplicateNumber = Set.copyOf(numbers);
        if (eliminateDuplicateNumber.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.CHECK_DUPLICATE.getMessage());
        }
    }

}
