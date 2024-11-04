package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.validator.LottoNumberValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number.getValue());
    }

    public int countMatch(Lotto other) {
        int matchCount = 0;
        for (int number : numbers) {
            if (other.numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}