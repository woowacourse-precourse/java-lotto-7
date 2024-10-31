package lotto;

import java.util.List;

public class LottoEvaluator {

    private final WinningNumbers winningNumbers;

    public LottoEvaluator(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoResult evaluate(List<Lotto> purchasedLotteries) {
        LottoResult lottoResult = new LottoResult();

        purchasedLotteries.stream().map(this::determineRank).forEach(lottoResult::incrementRankCount);

        return lottoResult;
    }

    private LottoRank determineRank(Lotto lotto) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::isWinningNumber).count();

        boolean hasBonus = winningNumbers.isBonusNumber(lotto);

        return LottoRank.getRank(matchCount, hasBonus);
    }
}
