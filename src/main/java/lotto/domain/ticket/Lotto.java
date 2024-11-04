package lotto.domain.ticket;

import lotto.validator.LottoValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
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
            if (other.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}