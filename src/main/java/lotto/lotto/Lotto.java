package lotto.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final String LOTTO_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size(); // 중복 확인
    }

    public int getNumbersSize() {
        return numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers; // 추가: 로또 번호를 외부에서 접근할 수 있도록 getter 추가
    }
}
