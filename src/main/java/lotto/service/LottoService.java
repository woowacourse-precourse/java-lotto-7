package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class LottoService {
    public LottoResult calculateResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean matchBonus = lotto.containsBonusNumbers(bonusNumber);
            Rank rank = Rank.getRank(matchCount, matchBonus);
            result.addResult(rank);
        }
        return result;
    }
}
