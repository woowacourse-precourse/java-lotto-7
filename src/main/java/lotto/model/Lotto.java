package lotto.model;

import static lotto.constant.LottoStatic.ERROR_MSG_PREFIX;
import static lotto.constant.LottoStatic.LOTTO_NUMBER_COUNTS;

import global.utils.Validator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //FIXME: validate 수정 가능?
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNTS) {
            throw new IllegalArgumentException(ERROR_MSG_PREFIX +
                    "로또 번호는 %d개여야 합니다.".formatted(LOTTO_NUMBER_COUNTS));
        }

        //FIXME: 여기 이렇게 있는게 맞을까?
        Validator.numbersDuplicateValidate(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
