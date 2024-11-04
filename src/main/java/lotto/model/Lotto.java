package lotto.model;

import static lotto.common.constant.LottoIntegerConstant.LOTTO_SIZE;
import static lotto.common.exception.ErrorMessage.LOTTO_NUMBERS_COUNT_ERROR;
import static lotto.common.exception.ErrorMessage.LOTTO_NUMBERS_DUPLICATION_ERROR;

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

    public List<LottoNumber> numbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateNumberCount(numbers);
        validateNoDuplication(numbers);
    }

    private void validateNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE.number()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_ERROR.message());
        }
    }

    private void validateNoDuplication(List<LottoNumber> numbers) {
        int distinctCount = Set.copyOf(numbers).size();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATION_ERROR.message());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
