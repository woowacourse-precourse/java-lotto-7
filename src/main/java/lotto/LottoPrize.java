package lotto;

import java.util.List;

public class LottoPrize extends Lotto {
    int bonusNumber;

    public LottoPrize(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }
}
