package lotto.domain;

import static lotto.domain.LottoPrize.FIRST_PRIZE;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer number;

    public WinningLotto(Lotto lotto, Integer number) {
        this.lotto = lotto;
        this.number = number;
    }

    public LottoPrize getLottoPrize(Lotto comparisonLotto) {
        long countSameNumbers = comparisonLotto.countSameNumbers(lotto);
        boolean containNumber = comparisonLotto.isContainNumber(number);

        return LottoPrize.of(countSameNumbers, containNumber);
    }
}
