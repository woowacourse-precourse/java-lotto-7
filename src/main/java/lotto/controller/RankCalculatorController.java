package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.RankCalculator;
import lotto.model.WinningNumber;

import java.util.List;
import java.util.Map;

public class RankCalculatorController {
    private final RankCalculator rankCalculator;
    private final WinningNumber winningNumber;

    public RankCalculatorController(WinningNumber winningNumber) {
        this.rankCalculator = new RankCalculator();
        this.winningNumber = winningNumber;
    }

    public Map<Rank,Integer> calculateResult(List<Lotto> lottos){
        List<Rank> ranks = rankCalculator.compareLottos(lottos, this.winningNumber);
        return rankCalculator.finalRank(ranks);
    }
}
