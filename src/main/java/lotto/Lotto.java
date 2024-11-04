package lotto;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("무작위 생성된 로또 번호가 6개가 아닙니다.");
        }

        HashSet<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size()!=numbers.size()){
            throw new IllegalArgumentException("무작위 생성된 로또 번호에 중복된 숫자가 있습니다.");
        }
        for (Integer number : numbers) {
            if (number < 1) {
                throw new IllegalArgumentException("무작위 생성된 로또 번호는 1 이상의 숫자여야 합니다.");
            }
            if (number > 45) {
                throw new IllegalArgumentException("무작위 생성된 로또 번호는 45 이하의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
