package lotto.model.domain;

import static lotto.constant.ErrorMessages.DUPLICATE_LOTTO_NUMBERS;
import static lotto.constant.ErrorMessages.INVALID_LOTTO_NUMBERS_SIZE;
import static lotto.constant.LottoGameConfig.LOTTO_NUMBERS_COUNT;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateUniqueLottoNumbers(numbers);
        validateLottoSize(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateUniqueLottoNumbers(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_SIZE);
        }
    }
}