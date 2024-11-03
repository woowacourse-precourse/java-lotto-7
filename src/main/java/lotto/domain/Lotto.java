package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public record Lotto(List<Integer> numbers) {

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static int LOTTO_SIZE = 6;

    public Lotto {
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException("로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
    }

    private void validateNumberRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new LottoException("로또 번호는 " + MIN_NUMBER + "에서 " + MAX_NUMBER + " 사이의 값이어야 합니다.");
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new LottoException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
