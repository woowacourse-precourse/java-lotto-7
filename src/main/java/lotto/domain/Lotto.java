package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import lotto.domain.exception.InvalidLottoNumberException;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    static final int PRICE = 1_000;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBERS_SIZE || new HashSet<Integer>(numbers).size() != NUMBERS_SIZE) {
            throw new InvalidLottoNumberException("로또 번호는 6개여야 합니다.");
        }
    }

    int getFilteredCount(Predicate<LottoNumber> predicate) {
        return (int) numbers.stream().filter(predicate).count();
    }

    boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers.stream().map(LottoNumber::number).sorted().toList();
    }
}

