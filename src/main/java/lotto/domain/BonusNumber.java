package lotto.domain;

import static lotto.util.IntegerConvertor.parse;
import static lotto.util.LottoNumberValidator.validateRange;

import java.util.List;

public class BonusNumber {
    private final int number;

    public BonusNumber(String bonusNumber, List<Integer> numbers) {
        validate(parse(bonusNumber), numbers);
        this.number = parse(bonusNumber);
    }

    private void validate(int number, List<Integer> numbers) {
        validateRange(number);
        validateDuplication(number, numbers);
    }

    private void validateDuplication(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 같을 수 없습니다.");
        }
    }

    public boolean isIn(Lotto lotto) {
        return lotto.getNumbers().contains(number);
    }

}
