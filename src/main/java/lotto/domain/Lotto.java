package lotto.domain;

import java.util.List;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;

public class Lotto {
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    @Override
    public String toString(){
        return String.join(DELIMITER, numbers.toString());
    }
}
