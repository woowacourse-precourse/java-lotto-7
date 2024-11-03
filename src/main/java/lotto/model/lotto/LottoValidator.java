package lotto.model.lotto;

import static lotto.model.ErrorMessages.Lotto.DUPLICATED;
import static lotto.model.ErrorMessages.Lotto.INVALID_RANGE;
import static lotto.model.ErrorMessages.Lotto.INVALID_SIZE;
import static lotto.model.lotto.LottoConstants.END_INCLUSIVE;
import static lotto.model.lotto.LottoConstants.START_INCLUSIVE;
import static lotto.model.lotto.LottoConstants.VALID_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    protected LottoValidator() {
    }

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
        numbers.forEach(LottoValidator::validateRange);
        validateNoDuplicate(numbers);
    }

    protected static void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    protected static void validateRange(int number) {
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            System.out.println("number = " + number);
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    protected static void validateSize(List<Integer> numbers) {
        if (numbers.size() != VALID_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }
}
