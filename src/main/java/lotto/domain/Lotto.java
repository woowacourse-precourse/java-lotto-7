package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTE_MIN_RANGE = 1;
    private static final int LOTTE_MAX_RANGE = 45;

    private static final String DUPLICATE_NUMBER_NOT_ALLOWED_MESSAGE = "[ERROR] 중복된 NUMBER가 존재하면 안됩니다.";
    private static final String SIX_NUMBERS_REQUIRED_MESSAGE = "[ERROR] 6개의 숫자를 입력해야 합니다.";
    private static final String LOTTO_NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1 ~ 45 사이여야 합니다.";


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_NOT_ALLOWED_MESSAGE);
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(SIX_NUMBERS_REQUIRED_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTE_MIN_RANGE || number > LOTTE_MAX_RANGE) {
                throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
