package lotto;

public class WinningChecker {
    private final Lotto winningNumber;
    private final Integer bonusNumber;
    private final LottoResult result;

    public WinningChecker(Lotto winningNumber, Integer bonusNumber, LottoResult result) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.result = result;
    }

    public void calculate(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer count = lotto.howManyMatches(winningNumber);
            WinningInfo winningInfo = WinningInfo.getWinningInfo(count);
            if (winningInfo.getInfo().equals("undefined")) {
                calculateFiveMatches(lotto);
            }
            result.updateResult(winningInfo);
        }
    }

    private void calculateFiveMatches(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            result.updateResult(WinningInfo.SECOND_WINNER);
        }
        if (!lotto.contains(bonusNumber)) {
            result.updateResult(WinningInfo.THIRD_WINNER);
        }
    }

}
