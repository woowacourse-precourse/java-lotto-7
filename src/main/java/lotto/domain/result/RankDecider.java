package lotto.domain.result;

import static lotto.constants.LottoRank.*;

public class RankDecider {

    public static int getRank( int matchedNumberCount, boolean isBonusNumberMatched  ) {

        if(matchedNumberCount < FIFTH.getMatchCount()){ return NO_LUCK.getRank();}
        if(matchedNumberCount == FIFTH.getMatchCount()){ return FIFTH.getRank();}
        if(matchedNumberCount == FOURTH.getMatchCount()){ return FOURTH.getRank();}
        if(matchedNumberCount == THIRD.getMatchCount() && !isBonusNumberMatched){ return THIRD.getRank();}
        if(matchedNumberCount == SECOND.getMatchCount()){ return SECOND.getRank();}

        return FIRST.getRank();
    }

}
