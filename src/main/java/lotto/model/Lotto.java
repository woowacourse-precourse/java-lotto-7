package lotto.model;

import java.util.List;
import lotto.utils.LottoValidator;

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

        //FIXME: 여기 이렇게 있는게 맞을까?
        LottoValidator.numbersDuplicateValidate(numbers);
    }

    // TODO: 추가 기능 구현
}
