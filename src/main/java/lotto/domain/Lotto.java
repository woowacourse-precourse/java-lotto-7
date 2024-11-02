package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoConstants.LOTTO_SIZE;
import static lotto.message.ErrorMessage.LOTTO_NUMBERS_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SIZE_ERROR;

public class Lotto {
    private final String DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATE.getMessage());
        }
    }

    @Override
    public String toString(){
        return String.join(DELIMITER, numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
