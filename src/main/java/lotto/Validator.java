package lotto;

import java.util.List;

public class Validator {
    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 양수로 입력해야 합니다.");
        }
        if (purchaseAmount % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public void validateWinningNum(List<Integer> winningNums) {
        if (winningNums.size() != Constant.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개 입력해야 합니다.");
        }
        for (int winningNum : winningNums) {
            if (winningNum < 0) {
                throw new IllegalArgumentException("[ERROR] 당첨번호는 양수로 입력해야 합니다.");
            }
            if (winningNum < Constant.LOTTO_START_NUM || winningNum > Constant.LOTTO_END_NUM ) {
                throw new IllegalArgumentException("[ERROR] 당첨번호를 범위 내로 입력해야 합니다.");
            }
        }
    }

    public void validateBonusNum(int bonusNum) {
        if (bonusNum < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스번호는 양수로 입력해야 합니다.");
        }
        if (bonusNum < Constant.LOTTO_START_NUM || bonusNum > Constant.LOTTO_END_NUM ) {
            throw new IllegalArgumentException("[ERROR] 보너스번호를 범위 내로 입력해야 합니다.");
        }
    }
}
