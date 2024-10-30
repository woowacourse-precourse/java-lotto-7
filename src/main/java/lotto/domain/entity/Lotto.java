package lotto.domain.entity;

import lotto.util.ValidLottoNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
        if (ValidLottoNumber.isBoundedNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 정수입니다.");
        }

        if (ValidLottoNumber.isSixNumbers(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (ValidLottoNumber.isDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 불가능 합니다.");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.numbers.iterator();
    }
}
