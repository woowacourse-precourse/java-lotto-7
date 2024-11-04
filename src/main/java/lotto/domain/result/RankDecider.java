package lotto.domain.result;

import static lotto.constants.LottoRank.FIFTH;
import static lotto.constants.LottoRank.FIRST;
import static lotto.constants.LottoRank.FOURTH;
import static lotto.constants.LottoRank.NO_LUCK;
import static lotto.constants.LottoRank.SECOND;
import static lotto.constants.LottoRank.THIRD;

public class RankDecider {

    public static int getRank(int matchedNumberCount, boolean isBonusNumberMatched) {

        if (matchedNumberCount < FIFTH.getMatchCount()) {
            return NO_LUCK.getRank();
        }
        if (matchedNumberCount == FIFTH.getMatchCount()) {
            return FIFTH.getRank();
        }
        if (matchedNumberCount == FOURTH.getMatchCount()) {
            return FOURTH.getRank();
        }
        if (matchedNumberCount == THIRD.getMatchCount() && !isBonusNumberMatched) {
            return THIRD.getRank();
        }
        if (matchedNumberCount == SECOND.getMatchCount()) {
            return SECOND.getRank();
        }

        return FIRST.getRank();
    }

}
