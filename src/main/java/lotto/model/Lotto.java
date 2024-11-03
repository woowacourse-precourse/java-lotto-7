package lotto.model;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberCountException;
import lotto.exception.LottoNumberOutOfRangeException;

public record Lotto(List<Integer> numbers) {
    public Lotto {
        validateLottoNumberCount(numbers);
        validateDuplicateLottoNumber(numbers);
        validateLottoNumbersRange(numbers);
    }

    @Override
    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoNumberCountException();
        }
    }

    private void validateDuplicateLottoNumber(List<Integer> numbers) {
        if (countDistinctUniqueNumbers(numbers) != NUMBER_COUNT) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void validateLottoNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumberRange);
    }

    private void validateLottoNumberRange(Integer number) {
        if (!isLottoNumberRange(number)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private long countDistinctUniqueNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

    public Integer getNumber(int index) {
        return numbers.get(index);
    }
}
