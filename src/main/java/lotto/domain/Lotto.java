package lotto.domain;

import java.util.List;

public class Lotto {

    public static final int MIN = 1;
    public static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < MIN || number > MAX)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
