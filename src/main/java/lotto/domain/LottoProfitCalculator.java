package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoProfitCalculator {
    private final List<LottoRank> lottoRanks = new ArrayList<>();
    private final LottoResult lottoResult;
    private final IssuedLotto issuedLotto;

    public LottoProfitCalculator(LottoResult lottoResult, IssuedRandomLotto issuedRandomLotto) {
        this.lottoResult = lottoResult;
        this.issuedLotto = issuedRandomLotto;
    }

    public List<LottoRank> calculateLottoStatistics() {
        for (Lotto issuedLotto : issuedLotto.getIssuedLottos()) {
            int hitLottoNumbers = calculateHitLottoNumbers(issuedLotto);
            boolean isBonusNumberHit = calculateHitBonusNumber(issuedLotto);
            LottoRank lottoRank = LottoRank.of(hitLottoNumbers, isBonusNumberHit);
            if (lottoRank != null) {
                lottoRanks.add(lottoRank);
            }
        }
        return lottoRanks;
    }

    private int calculateHitLottoNumbers(Lotto lotto) {
        int hitCount = 0;
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (lottoResult.getWinningNumbers().getNumbers().contains(lottoNumber)) {
                hitCount++;
            }
        }
        return hitCount;
    }

    private boolean calculateHitBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(this.lottoResult.getBonusNumber());
    }
}
