package lotto.util;

public class InputValidator {
    public void checkDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위이어야 합니다.");
        }
    }

    public void checkInRange1To45(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 ~ 45 사이의 번호이어야 합니다.");
        }
    }
}
