package lotto.model;

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

    // numbers 필드에 대한 getter 메서드
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);  // 방어적 복사
    }

    @Override
    public String toString() {
        return numbers.toString();  // 번호 리스트를 문자열로 반환
    }

    // TODO: 추가 기능 구현
}
