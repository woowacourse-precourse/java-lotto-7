package lotto.model;

import static lotto.message.ErrorMessage.DUPLICATED_NUMBER_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import lotto.dto.LottoStatus;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplication(numbers);

        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Comparator.naturalOrder());
    }

    public LottoStatus getStatus() {
        return new LottoStatus(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE.getContent());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for(int number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE.getContent());
        }
    }

    private void validateNumberRange(int number){
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE.getContent());
        }
    }

    private boolean isValidNumber(int number) {
        return 1 <= number && number <= 45;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return new HashSet<Integer>(numbers).size() != numbers.size();
    }
}
