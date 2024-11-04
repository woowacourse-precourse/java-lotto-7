package lotto.util;

import java.util.List;

public class Validator {

    public void validatePositiveAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

    public void validateAmountUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 입니다.");
        }
    }

    public void validateBonusRange(int bonusNum) {
        if(bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void validateBonusDuplicate(List<Integer> winningNumbers, int bonusNum) {
        if (winningNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복 불가 입니다.");
        }
    }

}
