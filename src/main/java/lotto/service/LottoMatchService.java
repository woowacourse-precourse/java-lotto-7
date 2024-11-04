package lotto.service;

import lotto.domain.*;

public class LottoMatchService {

    public LottoMatch match(LottoIssue lottoIssue, LottoJackpot lottoJackpot) {
        return new LottoMatch(lottoIssue.getLottos().stream()
                .map(lotto -> matchRank(lotto, lottoJackpot))
                .toList());
    }

    public LottoRank matchRank(Lotto issueLotto, LottoJackpot lottoJackpot) {
        long matchCount = getMatchCount(issueLotto, lottoJackpot);
        boolean matchBonusNumber = isMatchBonusNumber(issueLotto, lottoJackpot);

        return LottoRank.valueOf(matchCount, matchBonusNumber);
    }

    public long getMatchCount(Lotto issueLotto, LottoJackpot lottoJackpot) {
        return issueLotto.getNumbers().stream()
                .filter(lottoJackpot.getLotto().getNumbers()::contains)
                .count();
    }

    public boolean isMatchBonusNumber(Lotto issueLotto, LottoJackpot lottoJackpot) {
        return issueLotto.getNumbers().contains(lottoJackpot.getBonusNumber().getNumber());
    }
}
