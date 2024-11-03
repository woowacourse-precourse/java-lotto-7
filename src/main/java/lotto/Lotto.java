package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 번호 리스트를 검증하는 메서드
    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicates(numbers);
        checkNumberRange(numbers);
        Collections.sort(numbers); // 오름차순 정렬
    }

    // 번호 개수 확인
    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 중복 여부 확인
    private void checkDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    // 번호 범위 확인
    private void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
            }
        }
    }

    // 당첨 번호와 비교하여 일치 개수를 반환하는 메서드
    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    // 특정 번호가 포함되어 있는지 확인하는 메서드
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    // 로또 번호 출력용 toString 메서드
    @Override
    public String toString() {
        return numbers.toString();
    }
}
