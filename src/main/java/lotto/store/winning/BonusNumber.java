package lotto.store.winning;

import lotto.store.LottoNumber;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static BonusNumber from(int number) {
        return new BonusNumber(number);
    }

    public boolean equalNumber(int number) {
        return this.number == number;
    }

    private void validateNumberRange(int number) {
        if (LottoNumber.isNotRange(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
