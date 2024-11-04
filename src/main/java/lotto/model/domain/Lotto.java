package lotto.model.domain;

import static lotto.constant.ErrorMessages.DUPLICATE_LOTTO_NUMBER_ERROR;
import static lotto.constant.ErrorMessages.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.constant.LottoGameConfig.LOTTO_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;
import lotto.util.LottoNumberValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateUniqueLottoNumbers(numbers);
        validateLottoSize(numbers);
        validateNumbersInRange(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validateUniqueLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER_ERROR);
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(LottoNumberValidator::validateNumberInRange);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}