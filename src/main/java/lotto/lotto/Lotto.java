package lotto.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        System.out.println(Collections.unmodifiableList(numbers));
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
    }

    public int getNumbersSize() {
        return numbers.size();
    }
// TODO: 추가 기능 구현
}
