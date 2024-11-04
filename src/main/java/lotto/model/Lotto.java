package lotto.model;

import lotto.common.ConstantData;
import lotto.common.utils.ValidationUtils;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ValidationUtils.validateDuplicateWinNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() { return numbers; }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != ConstantData.NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }


    // TODO: 추가 기능 구현
}
