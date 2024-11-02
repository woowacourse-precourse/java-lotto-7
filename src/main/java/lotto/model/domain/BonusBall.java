package lotto.model.domain;

import lotto.model.ErrorMessage;

public class BonusBall {

    private final LottoNumber lottoNumber;

    public static BonusBall of(int number, WinningBalls winningBalls) {
        LottoNumber lottoNumber = new LottoNumber(number);
        validateDuplicate(lottoNumber, winningBalls);
        return new BonusBall(lottoNumber);
    }

    private static void validateDuplicate(LottoNumber lottoNumber, WinningBalls winningBalls) {
        if (winningBalls.hasNumber(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private BonusBall(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public LottoNumber getLottoNumber() {
        return this.lottoNumber;
    }
}

