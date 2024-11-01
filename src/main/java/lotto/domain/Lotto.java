package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkNumberRange(numbers);
        checkNumberDuplicated(numbers);
    }

    // TODO: 추가 기능 구현
    private void checkNumbersSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void checkNumberRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(number < 1 || number > 45){
                throw new IllegalArgumentException("[ERROR] 로또 번호가 숫자 범위를 벗어납니다.");
            }
        }
    }

    private void checkNumberDuplicated(List<Integer> numbers){
        Set<Integer> filterNumbers = new HashSet<>(numbers);
        if (filterNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복이 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
