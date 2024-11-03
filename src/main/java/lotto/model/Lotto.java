package lotto.model;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberCountException;
import lotto.exception.LottoNumberOutOfRangeException;

public record Lotto(List<LottoNumber> numbers) {
    public Lotto {
        validateLottoNumberCount(numbers);
        validateDuplicateLottoNumber(numbers);
        validateLottoNumbersRange(numbers);
    }

    @Override
    public List<LottoNumber> numbers() {
        return new ArrayList<>(numbers);
    }

    private void validateLottoNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoNumberCountException();
        }
    }

    private void validateDuplicateLottoNumber(List<LottoNumber> numbers) {
        if (countDistinctUniqueNumbers(numbers) != NUMBER_COUNT) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void validateLottoNumbersRange(List<LottoNumber> numbers) {
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(LottoNumber number) {
        if (!isLottoNumberRange(number)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean isLottoNumberRange(LottoNumber number) {
        return number.number() >= MIN_NUMBER && number.number() <= MAX_NUMBER;
    }

    private long countDistinctUniqueNumbers(List<LottoNumber> numbers) {
        return numbers.stream().distinct().count();
    }

    public LottoNumber getNumber(int index) {
        return numbers.get(index);
    }
}
