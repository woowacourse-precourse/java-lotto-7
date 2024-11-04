package lotto.util;

import java.util.List;

public class InputValidator {
    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    public void checkInRange1To45(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 번호이어야 합니다.");
        }
    }

    public void checkBonusNotInWinning(int bonusNum, List<Integer> winningNums) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public void validateAmount(int purchaseAmount) {
        checkMinimumAmount(purchaseAmount);
        checkMaximumAmount(purchaseAmount);
        checkDividedBy1000(purchaseAmount);
    }

    private void checkMinimumAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0원 이상이어야 합니다.");
        }
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }
    }

    private void checkMaximumAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 최대 100,000원까지 가능합니다.");
        }
    }

    private void checkDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % MIN_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위이어야 합니다.");
        }
    }
}
