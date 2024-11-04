package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exceptions.ArgumentException;
import lotto.exceptions.StateException;

public class BonusBall {
    private final int number;

    private BonusBall(final int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    private void validate(final int number, Lotto lotto) throws ArgumentException {
        if (lotto.has(number)) {
            throw ArgumentException.DUPLICATE_BONUS_BALL;
        }
    }

    public static BonusBall of(final int number, Lotto lotto) {
        return new BonusBall(number, lotto);
    }

    public static BonusBall createAutoBonusBall(Lotto lotto) {
        return of(pickNumberNotIn(lotto, LottoNumber.MAX_VALUE), lotto);
    }

    public static BonusBall createManualBonusBall(final int number, Lotto lotto) {
        return of(number, lotto);
    }

    public static int pickNumberNotIn(Lotto lotto, final int repeat) {
        if (repeat == 0) {
            throw StateException.EMPTY_AUTO_BONUS_BALL;
        }

        int randomNumber = Randoms.pickNumberInRange(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE);
        int[] duplicated = new int[LottoNumber.MIN_VALUE + LottoNumber.MAX_VALUE];

        if (lotto.has(randomNumber)) {
            duplicated[randomNumber] = 1;
        }

        if (!lotto.has(randomNumber) && duplicated[randomNumber] == 0) {
            return randomNumber;
        }

        return pickNumberNotIn(lotto, repeat - 1);
    }

    public LottoNumber getNumber() {
        return LottoNumber.valueOf(number);
    }

    public boolean equalTo(BonusBall other) {
        int is = LottoNumber.valueOf(this.number).compareTo(other.getNumber());

        if (is == 0) {
            return true;
        }

        return false;
    }

}
