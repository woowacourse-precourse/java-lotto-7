package lotto.domain;

import java.util.List;

import static lotto.domain.Lotto.MAX;
import static lotto.domain.Lotto.MIN;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int number) {
        if(number < MIN || number > MAX) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
