package lotto.validator;

import java.util.HashSet;
import java.util.List;
import lotto.model.LottoConstants;

public class LottoNumberValidator {

    private static final int NUMBER_COUNT = LottoConstants.NUMBER_COUNT.getValue();
    private static final int MAX_NUMBER = LottoConstants.MAX_NUMBER.getValue();
    private static final int MIN_NUMBER = LottoConstants.MIN_NUMBER.getValue();

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private static void validateNoDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateEachNumberRange(number);
        }
    }

    private static void validateEachNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_NUMBER + "부터 " + MAX_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }

}
