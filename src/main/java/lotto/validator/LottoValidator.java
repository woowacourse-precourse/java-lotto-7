package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LottoValidator extends Validator {
    static public final int NUMBERS_LENGTH = 6;
    static public final int LOTTO_MIN_NUMBER = 1;
    static public final int LOTTO_MAX_NUMBER = 45;

    static final String ERROR_INVALID_LENGTH = "로또 번호는 6개여야 합니다.";
    static final String ERROR_DUPLICATE_NUMBER = "로또 번호는 중복될 수 없습니다.";
    static final String ERROR_INVALID_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";


    private LottoValidator() {
        // 인스턴스화 방지를 위해서 사용
    }

    static public void validate(List<Integer> numbers) {

        checkLength(numbers);
        checkDuplicates(numbers);
        checkRange(numbers);
    }

    static void checkLength(List<Integer> numbers) {

        if (numbers.size() != NUMBERS_LENGTH) {
            throwInvalidInputException(ERROR_INVALID_LENGTH);
        }
    }

    static void checkDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() < NUMBERS_LENGTH) {
            throwInvalidInputException(ERROR_DUPLICATE_NUMBER);
        }
    }

    static void checkRange(List<Integer> numbers) {

        for (Integer i : numbers) {
            if (i < LOTTO_MIN_NUMBER || i > LOTTO_MAX_NUMBER) {
                throwInvalidInputException(ERROR_INVALID_RANGE);
            }
        }

    }
}
