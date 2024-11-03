package lotto;

import lotto.exception.InputException;

import java.util.HashSet;
import java.util.List;

import static lotto.global.ErrorCode.*;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new InputException(NUMBER_NOT_SIX);
        }

        if(set.size() != 6) throw new InputException(HAS_NUMBER_EXIST);
    }

    // TODO: 추가 기능 구현


    public void setBonusNumber(int bonusNumber) {
        if (bonusNumber <= 0) throw new InputException(BONUS_NUMBER_ZERO_AND_LESS);
        if (numbers.contains(bonusNumber)) throw new InputException(WIN_NOT_EXIST_NUMBER);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
