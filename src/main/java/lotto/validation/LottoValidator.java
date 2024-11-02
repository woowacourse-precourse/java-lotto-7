package lotto.validation;

import lotto.domain.LottoInfo;

public class LottoValidator {
    public static void isLottoNumInRange(int winningNum) {
        if (!(LottoInfo.MIN_NUM_RANGE <= winningNum && winningNum <= LottoInfo.MAX_NUM_RANGE)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
