package lotto.domain;

import static lotto.exception.lotto.LottoErrorCode.INVALID_DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.lotto.LottoErrorCode.INVALID_LOTTO_LENGTH;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateUniqueLottoNumbers(numbers);
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(INVALID_LOTTO_LENGTH);
        }
    }

    private void validateUniqueLottoNumbers(List<Integer> numbers) {
        if (!isUniqueNumbers(numbers)) {
            throw new LottoException(INVALID_DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    public long countSameNumbers(Lotto comparisonLotto) {
        return comparisonLotto.numbers.stream().filter(numbers::contains).count();
    }

    public boolean isContainNumber(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
