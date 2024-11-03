package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        sortLotto(sortNumbers);
        this.numbers = sortNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static void sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
