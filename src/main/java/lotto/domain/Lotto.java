package lotto.domain;

import lotto.error.LottoErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_SIZE_EXCEPTION.getMsg());

        Set<Integer> tempSet = new HashSet<>(numbers);
        if(numbers.size() != tempSet.size())
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_DUPLICATION_EXCEPTION.getMsg());
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
