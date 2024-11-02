package lotto.domain;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Buyer {
    private final Cost cost;
    private final Lottos lottos;
    private final ScoreBoard scoreBoard;

    public Buyer(Cost cost, Lottos lottos) {
        this.cost = cost;
        this.lottos = lottos;
        this.scoreBoard = new ScoreBoard();
    }

    public double calculateReturnRate() {
        long totalAmount = 0;
        for (LottoRank rank : scoreBoard.getScoreBoard().keySet()) {
            totalAmount += rank.getWinningAmount() * scoreBoard.getWinningCount(rank);
        }
        return (double) totalAmount * 100 / cost.getCost();
    }

    public void recordTotalScore(DrawnNumbers drawnNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank rank = calculateRank(lotto, drawnNumbers);
            scoreBoard.record(rank);
        }
    }

    private LottoRank calculateRank(Lotto lotto, DrawnNumbers drawnNumbers) {
        Set<Number> set = copy(lotto);
        set.removeAll(drawnNumbers.getWinningNumbers().getNumbers());
        int misMatchCount = set.size();
        boolean isMatchedBonus = set.contains(drawnNumbers.getBonusNumber().getNumber());
        
        if (misMatchCount == 0) {
            return LottoRank.FIRST;
        }
        if (misMatchCount == 1 && isMatchedBonus) {
            return LottoRank.SECOND;
        }
        if (misMatchCount == 1 && !isMatchedBonus) {
            return LottoRank.THIRD;
        }
        if (misMatchCount == 2) {
            return LottoRank.FOURTH;
        }
        if (misMatchCount == 3) {
            return LottoRank.FiFTH;
        }
        return LottoRank.ETC;
    }

    private static Set<Number> copy(Lotto lotto) {
        return new HashSet<>(lotto.getNumbers());
    }

    public Map<LottoRank, Integer> getScoreBoard() {
        return scoreBoard.getScoreBoard();
    }
}
