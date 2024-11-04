package lotto.controller;

import java.util.List;
import java.util.Objects;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoRanks;
import lotto.model.WinningNumbers;
import lotto.utils.LottoRank;

public class LottoReader {
    public static LottoRanks computeLottoBundleResult(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<LottoRank> lottoRanks = lottoBundle.getLottos().stream().map(lotto -> computeSingleLottoResult(lotto, winningNumbers, bonusNumber)).filter(Objects::nonNull).toList();
        
        return new LottoRanks(lottoRanks);
    }

    public static LottoRank computeSingleLottoResult(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Integer matchCount = 0;
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(lottoNumber)) {
                matchCount++;
            }
        }
        boolean containsBonusNumber = lotto.getNumbers().contains(bonusNumber.getBonusNumber());

        return LottoRank.getLottoRankByMatchResult(matchCount, containsBonusNumber);
    }
}
