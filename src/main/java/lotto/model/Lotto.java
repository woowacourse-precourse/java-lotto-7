package lotto.model;

import static lotto.constants.GlobalLottoConst.MAX_LOTTO_NUMBER;
import static lotto.constants.GlobalLottoConst.MAX_LOTTO_NUMBERS_COUNT;
import static lotto.constants.GlobalLottoConst.MIN_LOTTO_NUMBER;
import static lotto.message.ErrorMessage.DUPLICATED_NUMBER_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_NUMBER_COUNT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.INVALID_NUMBER_RANGE_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoStatus;

public class Lotto {

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
        if (numbers.size() != MAX_LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE.getContent());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberRange(number);
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

    private void validateDuplication(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE.getContent());
        }
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
