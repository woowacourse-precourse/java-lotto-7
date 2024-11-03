package lotto.model;

import static lotto.Constants.LOTTO_MAX_NUMBER;
import static lotto.Constants.LOTTO_MIN_NUMBER;

public record WinningNumbers(Lotto lotto, int bonusBall) {

    public WinningNumbers {
        validate(lotto, bonusBall);
    }

    private void validate(Lotto lotto, int bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonusBall < LOTTO_MIN_NUMBER || bonusBall > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼은 1부터 45까지의 숫자만 가능합니다.");
        }
    }
}
