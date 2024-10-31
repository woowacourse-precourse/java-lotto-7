package lotto.model;

import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_COUNT_ERROR;
import static lotto.common.exception.ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR;

import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateNumberCount(numbers);
        validateNoDuplication(numbers);
    }

    private void validateNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR.message());
        }
    }

    private void validateNoDuplication(List<LottoNumber> numbers) {
        int distinctCount = Set.copyOf(numbers).size();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION_ERROR.message());
        }
    }
}
