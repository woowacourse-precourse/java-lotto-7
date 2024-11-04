package lotto.helper;

import lotto.model.rank.DrawResultRankTable;
import lotto.model.rank.RankCondition;

public class DrawResultRankTableHelper {
    private DrawResultRankTableHelper() {
    }

    public static DrawResultRankTable oneSecondRankAndTwoThirdRank() {
        DrawResultRankTable initiate = DrawResultRankTable.initiate();
        initiate.updateIfPresent(RankCondition.SECOND);
        initiate.updateIfPresent(RankCondition.THIRD);
        initiate.updateIfPresent(RankCondition.THIRD);
        return initiate;
    }

    public static DrawResultRankTable oneFifthRank() {
        DrawResultRankTable initiate = DrawResultRankTable.initiate();
        initiate.updateIfPresent(RankCondition.FIFTH);
        return initiate;
    }
}
