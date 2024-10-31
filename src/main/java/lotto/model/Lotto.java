package lotto.model;

import java.util.List;
import lotto.common.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_MUST_SIX.getMessage());
        }
    }

    private void validateNumberRange(Integer number){
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자 범위는 1~45까지입니다.");
        }
    }

    // TODO: 추가 기능 구현
}
