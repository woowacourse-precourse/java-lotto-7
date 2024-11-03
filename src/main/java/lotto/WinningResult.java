package lotto;

import lotto.Lotto;
import lotto.Price;

public class WinningResult {

    private final Lotto lotto;
    private final int bonusball;

    public WinningResult(Lotto lotto, int bonusball) {
        this.lotto = lotto;
        this.bonusball = bonusball;
    }

    public Price match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusball);
        return Price.value(countOfMatch, bonusCheck);
    }


}
