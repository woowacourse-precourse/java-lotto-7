package lotto.validator;

import java.util.HashSet;
import java.util.List;

import static lotto.constants.LottoValue.LOTTO_NUMBER_COUNT;

public class LottoValidator {
    private static final String ERROR_LOTTO_COUNT = "로또 번호는 6개여야 합니다.";
    private static final String ERROR_LOTTO_NUMBER_DUPLICATE = "로또 번호는 중복을 허용하지 않습니다.";

    public static void validateLotto(List<Integer> numbers){
        checkNumberCount(numbers);
        checkNumberDuplicate(numbers);
    }

    private static void checkNumberCount(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_COUNT.getValue()){
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT);
        }
    }

    private static void checkNumberDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATE);
        }
    }
}
