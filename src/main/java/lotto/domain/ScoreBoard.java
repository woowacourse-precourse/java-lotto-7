package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class ScoreBoard {
    private final Map<LottoRank, Integer> scoreBoard;

    public ScoreBoard() {
        this.scoreBoard = new EnumMap<>(LottoRank.class);
    }

    public void record(LottoRank rank) {
        scoreBoard.put(rank, scoreBoard.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getScoreBoard() {
        return scoreBoard;
    }

    public int getWinningCount(LottoRank rank) {
        return scoreBoard.get(rank);
    }
}
