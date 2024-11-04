package model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumCount(numbers);
        validateNumbDuplicate(numbers);
    }
    private void validateNumCount(List<Integer> numbers) { // 번호 카운트 확인 메서드
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbDuplicate(List<Integer> numbers) { //번호 중복 확인 메서드

    }
}
