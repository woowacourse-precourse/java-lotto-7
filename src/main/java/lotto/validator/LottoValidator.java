package lotto.validator;

import java.util.List;

public class LottoValidator {
    private static final String ERROR_LOTTO_COUNT = "로또 번호는 6개여야 합니다.";
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    public static void validateLotto(List<Integer> numbers){
        checkNumberCount(numbers);
    }

    private static void checkNumberCount(List<Integer> numbers) {
        if(numbers.size() != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ERROR_LOTTO_COUNT);
        }
    }
}
