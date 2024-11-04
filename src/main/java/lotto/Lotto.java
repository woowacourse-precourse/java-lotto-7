package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); // 리스트 복사하여 변경 가능하게!
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 리스트는 null일 수 없습니다.");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 포함될 수 없습니다.");
        }

        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers); // 불변 리스트 반환
    }

    // TODO: 추가 기능 구현
}
