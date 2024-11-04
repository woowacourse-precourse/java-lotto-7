package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final Number number;

    public WinningLotto(Lotto lotto, Number number) {
        this.lotto = lotto;
        this.number = number;
    }

    public LottoPrize getLottoPrize(Lotto comparisonLotto) {
        long countSameNumbers = comparisonLotto.countSameNumbers(lotto);
        boolean containNumber = comparisonLotto.isContainNumber(number);

        return LottoPrize.of(countSameNumbers, containNumber);
    }
}
