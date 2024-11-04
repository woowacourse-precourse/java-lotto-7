package lotto.model;

import lotto.constant.LottoConstants;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.PICK_COUNT) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.",
                    LottoConstants.PICK_COUNT));
        }
    }

    // TODO: 추가 기능 구현
}
