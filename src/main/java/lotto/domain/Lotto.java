package lotto.domain;

import lotto.exception.LottoException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final Integer LOTTO_SIZE = 6;
    private static final Integer LOTTO_MIN_NUM = 1;
    private static final Integer LOTTO_MAX_NUM = 45;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        numbers.forEach(this::validateRange);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) // 로또 번호가 6자리가 아닐 경우
            throw new IllegalArgumentException(LottoException.LOTTO_LENGTH_NOT_VALID.getMessage());
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) // 로또 번호 중 중복 값이 있을 경우
            throw new IllegalArgumentException(LottoException.WINNING_NUMBERS_DUPLICATED.getMessage());
    }

    private void validateRange(final Integer num) {
        if (num < LOTTO_MIN_NUM || num > LOTTO_MAX_NUM) // 입력 받은 당첨 번호 혹은 보너스 번호가 1~45 범위를 벗어날 경우
            throw new IllegalArgumentException(LottoException.LOTTO_RANGE_NOT_VALID.getMessage());
    }
}
