package lotto.model;

import java.util.List;
import java.util.Set;

import static lotto.provider.NumberProvider.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        for(Integer number: numbers){
            if (number < MIN_NUMBER || number > MAX_NUMBER)
                throw new IllegalArgumentException("로또 번호는 1~45 사이 숫자여야합니다.");
        }
        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static boolean isDuplicateNumber(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != numbers.size();
    }

}
