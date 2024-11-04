package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto { // 일급컬렉션으로 사용
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String LOTTO_NUMBER_RANGE_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!number.toString().matches(LOTTO_NUMBER_RANGE_REGEX)) {
                throw new IllegalArgumentException("[ERROR] 숫자의 범위는 1~45까지 입니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
