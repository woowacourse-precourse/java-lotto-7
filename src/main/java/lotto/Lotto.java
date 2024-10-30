package lotto;

import java.util.List;
import constants.Constants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_MAIN_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 "+Constants.LOTTO_MAIN_COUNT+"개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
