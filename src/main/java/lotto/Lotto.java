package lotto;

import java.util.Collections;
import java.util.List;
import lotto.Vaildator.InputValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sorting(numbers);
    }

    private void validate(List<Integer> numbers) {
        InputValidator.valid(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers; // 번호 반환
    }

    public String toString() {
        return numbers.toString(); // 번호 출력
    }

    private List<Integer> sorting(List<Integer> numbers) {
        Collections.sort(numbers); // 오름차순 정렬
        return numbers;
    }
}
