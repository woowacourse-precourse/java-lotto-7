package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.validator.LottoNumberValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean contains(int number) {
        return numbers.contains(number);
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

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}