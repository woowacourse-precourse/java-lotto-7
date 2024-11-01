package lotto.model.lotto.validator;

import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.exception.InvalidLottoNumberException;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        boolean outOfRange = numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX);

        if (outOfRange) {
            throw new InvalidLottoNumberException(
                    "[ERROR] 로또 번호는 " + LOTTO_NUMBER_MIN + "부터 " + LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.");
        }
    }
}
