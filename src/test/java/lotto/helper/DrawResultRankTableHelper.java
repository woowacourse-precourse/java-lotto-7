package lotto.helper;

import lotto.model.rank.DrawResultRankTable;
import lotto.model.rank.RankCondition;

public class DrawResultRankTableHelper {
    private DrawResultRankTableHelper() {
    }

    public static DrawResultRankTable initiate() {
        return DrawResultRankTable.initiate();
    }

    public static DrawResultRankTable oneSecondRankAndTwoThirdRank() {
        DrawResultRankTable initiate = DrawResultRankTable.initiate();
        initiate.updateResultRankTable(RankCondition.SECOND);
        initiate.updateResultRankTable(RankCondition.THIRD);
        initiate.updateResultRankTable(RankCondition.THIRD);
        return initiate;
    }
}
