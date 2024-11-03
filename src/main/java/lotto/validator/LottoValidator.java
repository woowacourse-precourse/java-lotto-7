package lotto.validator;

import java.util.List;

public class LottoValidator {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45까지의 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATION = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";

    public static void validateLotto(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateLottoNumbersDuplication(numbers);
        validateLottoNumberRange(numbers);
    }

    private static void validateLottoNumberRange(List<Integer> numbers) {
        boolean hasOutOfRangeNumber = numbers.stream()
                .anyMatch(LottoValidator::isOutOfRange);
        if (hasOutOfRangeNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_RANGE);
        }
    }

    private static boolean isOutOfRange(Integer number) {
        return number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER;
    }

    private static void validateLottoNumbersDuplication(List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        int count = numbers.size();
        if (distinctCount != count) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_DUPLICATION);
        }
    }

    private static void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_COUNT);
        }
    }
}
