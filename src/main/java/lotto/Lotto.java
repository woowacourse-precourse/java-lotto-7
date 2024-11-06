package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final String NOT_SIX = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String SAME_NUMBER = "[ERROR} 로또 번호에 중복된 숫자가 존재합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_SIX);
        }
        if(new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(SAME_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
