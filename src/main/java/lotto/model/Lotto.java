package lotto.model;

import static lotto.message.ErrorMessage.DUPLICATED_NUMBER_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoStatus;

public class Lotto {

    private final static int MAX_LOTTO_NUMBER_COUNT = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateNumbersRange(numbers);
        validateDuplication(numbers);

        this.numbers = initLottoNumbers(numbers);
    }

    public LottoStatus getStatus() {
        return new LottoStatus(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE.getContent());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE.getContent());
        }
    }

    private void validateNumberRange(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_ERROR_MESSAGE.getContent());
        }
    }

    private boolean isValidNumber(int number) {
        return MIN_LOTTO_NUMBER <= number && number <= MAX_LOTTO_NUMBER;
    }

    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> notDuplicatedNumbers = new HashSet<>(numbers);
        return notDuplicatedNumbers.size() != numbers.size();
    }

    private List<Integer> initLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
