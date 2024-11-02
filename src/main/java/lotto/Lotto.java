package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumber(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers); // 원본 리스트 복사
        Collections.sort(sortedNumbers); // 오름차순 정렬
        return sortedNumbers; // 정렬된 리스트 반환
    }

    private void validateNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45))
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
    }

    private void checkDuplicate(List<Integer> nums) {
        Set<Integer> uniqueNumbers = new HashSet<>(nums);
        if (uniqueNumbers.size() != nums.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
