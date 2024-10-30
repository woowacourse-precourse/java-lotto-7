package lotto.domain.entity;

import lotto.exception.LottoException;
import lotto.exception.LottoNumberExceptionMessage;
import lotto.util.ValidLottoNumber;

import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<Integer> {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!ValidLottoNumber.isBoundedNumbers(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBER_BOUNDED_EXCEPTION);
        }

        if (ValidLottoNumber.isSixNumbers(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.NUMBERS_LENGTH_EXCEPTION);
        }

        if (ValidLottoNumber.isDuplicate(numbers)) {
            throw new LottoException(LottoNumberExceptionMessage.DUPLICATE_EXCEPTION);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.numbers.iterator();
    }
}
