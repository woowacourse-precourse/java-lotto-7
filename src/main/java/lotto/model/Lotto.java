package lotto.model;

import java.util.List;
import lotto.value.LottoNumbers;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(List<Integer> numbers) {
//        validate(numbers);
        this.numbers = LottoNumbers.of(numbers);
    }

//    private void validate(LottoNumbers numbers) {
//        if (numbers.size() != 6) {
//            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
//        }
//    }

    // TODO: 추가 기능 구현
}
