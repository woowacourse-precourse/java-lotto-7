package lotto.model;

public class LottosResultCalculator {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;
    private final LottosResult lottosResult;

    private LottosResultCalculator(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottosResult = new LottosResult();
    }

    public static LottosResultCalculator of(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new LottosResultCalculator(lottos, winningNumbers, bonusNumber);
    }

    public void calculateLottosResult() {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            calculateLottoResult(lotto);
        }
    }

    private void calculateLottoResult(Lotto lotto) {
        int numberMatchingCount = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            Integer winningNumber = winningNumbers.get(i);
            if (lotto.contains(winningNumber)) {
                numberMatchingCount++;
            }
        }
        boolean containsBonusNumber = lotto.contains(bonusNumber.getBonusNumber());
        LottoRank lottoRank = LottoRank.calculateLottoRank(numberMatchingCount, containsBonusNumber);
        lottosResult.plus(lottoRank);
    }

    public LottosResult getLottosResult() {
        return lottosResult;
    }
}
