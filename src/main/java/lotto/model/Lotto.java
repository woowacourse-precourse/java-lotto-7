package lotto.model;

import static lotto.constant.LottoConstants.NUMBER_COUNT;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberCountException;

public final class Lotto {
    private final Set<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
        validateDuplicateLottoNumber();
    }

    public Set<LottoNumber> getNumbers() {
        return new TreeSet<>(this.numbers);
    }

    public boolean containsLottoNumber(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new LottoNumberCountException();
        }
    }

    private void validateDuplicateLottoNumber() {
        if (size() != NUMBER_COUNT) {
            throw new DuplicateLottoNumberException();
        }
    }

    private int size() {
        return this.numbers.size();
    }
}
