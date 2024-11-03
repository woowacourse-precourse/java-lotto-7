package lotto.domain;

import static lotto.domain.LottoConstants.IS_DUPLICATE_NUMBER;
import static lotto.domain.LottoConstants.IS_NOT_LOTTO_SIZE;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        validateLottoSetSize(numbers);
        valdiateDuplicate(numbers);
    }

    private void valdiateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    private void validateLottoSetSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    // TODO: 추가 기능 구현
}
