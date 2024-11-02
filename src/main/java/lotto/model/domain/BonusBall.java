package lotto.model.domain;

import lotto.model.ErrorMessage;

public class BonusBall {

    private final LottoNumber lottoNumber;

    public static BonusBall of(int number, WinningBalls winningBalls) {
        validateDuplicate(number, winningBalls);
        return new BonusBall(new LottoNumber(number));
    }

    private static void validateDuplicate(int number, WinningBalls winningBalls) {
        if (winningBalls.hasNumber(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private BonusBall(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getNumber() {
        return this.lottoNumber.getNumber();
    }
}

