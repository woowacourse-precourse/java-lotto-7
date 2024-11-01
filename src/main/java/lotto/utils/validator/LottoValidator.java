package lotto.utils.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator implements Validator<List<Integer>> {
    private static final String LOTTO_NUMBER_SIZE_IS_SIX = "로또 번호는 6개의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_NO_DUPLICATE = "로또 번호는 중복되면 안됩니다.";
    private static final String LOTTO_NUMBER_IS_RANGE = "로또 번호의 범위는 1~45 입니다.";

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueness(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_IS_SIX);
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_NO_DUPLICATE);
        }
    }

    private void validateRange(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_RANGE);
            }
        }
    }

}
