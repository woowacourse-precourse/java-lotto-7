package lotto.domain;

import lotto.dto.MatchCondition;
import lotto.enums.LottoRank;

public class ProfitCalculator {

    public long calculateWinningAmount(MatchCondition matchCondition) {
        LottoRank rank = LottoRank.of(matchCondition.matchCount(), matchCondition.containBonusNumber());
        return rank.getMoney();
    }
}
