package lotto.service;

import java.util.List;
import lotto.common.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;

public class LottoResultService {

    public LottoResult getLottoResult(List<Lotto> lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottoResult lottoResult = LottoResult.initialize();

        for (Lotto lotto : lottos) {
            LottoRank rank = calculateLottoRank(lotto, winningNumbers, bonusNumber);
            lottoResult = lottoResult.addResult(rank);
        }

        return lottoResult;
    }

    private LottoRank calculateLottoRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = countMatchingNumbers(lotto, winningNumbers);
        boolean matchBonus = isMatchBonusNumber(lotto, bonusNumber);

        return LottoRank.of(matchCount, matchBonus);
    }

    private int countMatchingNumbers(Lotto lotto, WinningNumbers winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.numbers()::contains)
                .count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber.number());
    }
}