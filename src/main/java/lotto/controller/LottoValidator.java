package lotto.controller;

public class LottoValidator {
    public void isValidAmount(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException("금액은 최소 1,000원 이상이어야 합니다.");
        }
        if(purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(("금액은 1,000원 단위여야 합니다."));
        }
    }

    public void isValidBounusNumber(int bounusNumber) {
        if(bounusNumber < 1 || bounusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
