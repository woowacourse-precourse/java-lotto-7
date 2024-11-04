package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    /**
     * 담겨있는 로또번호들을 정렬하여 반환합니다. 원본은 정렬되지 않습니다.
     *
     * @return 정렬된 로또번호 리스트
     */
    public List<Integer> getSortedNumbers() {
        List<Integer> orderedNumbers = new ArrayList<>(this.numbers);
        orderedNumbers.sort(Integer::compareTo);
        return orderedNumbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = this.getSortedNumbers();
        return sortedNumbers.toString();
    }
}
