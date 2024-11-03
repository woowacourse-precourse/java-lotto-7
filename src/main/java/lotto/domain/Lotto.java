package lotto.domain;

import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoNumberConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumberConstants.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_COUNT.format());
        }

        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBERS.format());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
