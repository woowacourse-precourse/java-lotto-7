package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import lotto.util.messages.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 입력된 로또 번호가 6개인지 판별
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_NOT_SIX.getMessage());
        }
        // 입력된 로또 번호에 중복된 값이 있는지 판별
        if (numbers.stream().collect(Collectors.toSet()).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    protected List<Integer> getLottoNumbers() {
        return this.numbers;
    }
}
