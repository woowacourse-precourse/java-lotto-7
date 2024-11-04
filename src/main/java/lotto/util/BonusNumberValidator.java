package lotto.util;

import java.util.List;

public class BonusNumberValidator {
    public static void validate(int bonusNum, List<Integer> winningLotto) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        if (winningLotto.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 당첨 번호와 중복되지 않아야 합니다.");
        }
    }
}
