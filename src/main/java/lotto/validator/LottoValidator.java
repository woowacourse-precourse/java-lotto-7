package lotto.validator;

import java.util.List;
import lotto.model.LottoConstants;

public class LottoValidator {

    public static final String ERROR_MESSAGE_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATION = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";

    public static void validateLotto(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersDuplication(numbers);
        validateLottoNumberRange(numbers);
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_RANGE);
        }
    }

    private static boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(LottoValidator::isOutOfRange);
    }

    private static boolean isOutOfRange(Integer number) {
        return number > LottoConstants.MAX_LOTTO_NUMBER.getValue()
                || number < LottoConstants.MIN_LOTTO_NUMBER.getValue();
    }

    private static void validateLottoNumbersDuplication(List<Integer> numbers) {
        long distinctCount = getDistinctCount(numbers);
        int totalCount = numbers.size();
        if (distinctCount != totalCount) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATION);
        }
    }

    private static long getDistinctCount(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_COUNT.getValue()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_COUNT);
        }
    }
}
