package lotto.validator;

import lotto.common.error.LottoErrorMessage;

import java.util.List;

public class LottoValidator {
    private LottoValidator() {}

    public static void validateSufficient(List<Integer> numbers) {
        boolean isValid = numbers.size() == 6;
        if (!isValid) {
            throw new IllegalArgumentException(LottoErrorMessage.INSUFFICIENT_WINNER_NUMBERS.getInfoMessage());
        }
    }
    public static void validateDuplicate(List<Integer> numbers) {
        boolean isValid = numbers.stream().distinct().count() == numbers.size();
        if (!isValid) {
            throw new IllegalArgumentException(LottoErrorMessage.CONFLICT_WINNER_NUMBERS.getInfoMessage());
        }
    }
    public static void validateValueRange(List<Integer> numbers) {
        boolean isValid = numbers.stream().allMatch(num -> num >= 1 && num <= 45);
        if (!isValid) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_WINNER_NUMBERS.getInfoMessage());
        }

    }
}
