package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.number.Number;
import lotto.domain.number.Numbers;

public class LottoMatcher {
    public Rank calculateRank(final Lotto lotto, final WinningInfo winningInfo) {
        return Rank.of(countMatches(lotto, winningInfo), hasBonusNumber(lotto, winningInfo));
    }

    private int countMatches(final Lotto lotto, final WinningInfo winningInfo) {
        List<Number> lottoNumbers = getLottoNumbers(lotto);
        List<Number> winningLottoNumbers = getWinningLottoNumbers(winningInfo.getWinningNumbers());

        return (int) lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    private boolean hasBonusNumber(final Lotto lotto, final WinningInfo winningInfo) {
        List<Number> lottoNumbers = getLottoNumbers(lotto);

        return lottoNumbers.contains(winningInfo.getBonusNumber());
    }
    
    private List<Number> getLottoNumbers(final Lotto lotto) {
        return lotto.getLottoNumbers().getNumbers();
    }

    private List<Number> getWinningLottoNumbers(final Numbers winningNumbers) {
        return winningNumbers.getNumbers();
    }
}
