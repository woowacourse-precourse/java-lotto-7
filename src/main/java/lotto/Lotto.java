package lotto;

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

    private void validNumberRange(int number){
        if(1 > number && number < 45){
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1~45 사이의 숫자이어야 합니다.");
        }
    }
}
