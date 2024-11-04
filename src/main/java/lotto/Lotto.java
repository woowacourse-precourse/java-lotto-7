package lotto;

import lotto.common.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkLottoNumberSize(numbers);
        checkDuplicated(numbers);
    }

    private static void checkLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.lottoNumberSizeNot6);
        }
    }

    private static void checkDuplicated(List<Integer> numbers) {
        Set<Integer> sets = new HashSet<>(numbers);
        if(numbers.size() != sets.size()) {
            throw new IllegalArgumentException(ErrorMessage.lottoNumberDuplicated);
        }
    }

    // TODO: 추가 기능 구현
}
