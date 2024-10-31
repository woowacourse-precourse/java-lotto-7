package lotto.helper;

import lotto.model.rank.DrawResultRankTable;

public class ResultRankTableHelper {
    private ResultRankTableHelper() {
    }

    public static DrawResultRankTable mock() {
        return DrawResultRankTable.initiate();
    }
}
