package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> sixNumbers = new HashSet<>(numbers);

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (sixNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        return sortedNumbers;
    }
}
