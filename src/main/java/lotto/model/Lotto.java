package lotto.model;

import java.util.Collections;
import java.util.List;

    public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers=sortLotto(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 45;
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.get(0)<MIN_NUMBER || numbers.get(5)>=MAX_NUMBER){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }
    private List<Integer> sortLotto(List <Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
