package lotto.domain;

import static lotto.constant.lotto.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.exception.lotto.LottoErrorCode.INVALID_DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.lotto.LottoErrorCode.INVALID_LOTTO_LENGTH;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().map(Number::new).toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumbersSize(numbers);
        validateUniqueLottoNumbers(numbers);
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT.getIntValue()) {
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
        return comparisonLotto.numbers.stream()
                .filter(this::isContainNumber)
                .count();
    }

    public boolean isContainNumber(Number number) {
        return numbers.stream()
                .anyMatch(n -> n.getNumber().equals(number.getNumber()));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
