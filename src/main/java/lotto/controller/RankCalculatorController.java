package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.RankCalculator;
import lotto.model.WinningNumber;
import lotto.util.CommonIo;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class RankCalculatorController {
    private final RankCalculator rankCalculator;
    private final WinningNumber winningNumber;
    private final OutputView outputView;

    public RankCalculatorController(WinningNumber winningNumber) {
        this.rankCalculator = new RankCalculator();
        this.winningNumber = winningNumber;
        this.outputView = new OutputView(new CommonIo());
    }

    public Map<Rank,Integer> calculateResult(List<Lotto> lottos){
        List<Rank> ranks = rankCalculator.compareLottos(lottos, this.winningNumber);
        return rankCalculator.finalRank(ranks);
    }

    public void printResult(Map<Rank,Integer> result){
        outputView.printStaticsFormat();
        for(Rank rank : Rank.values()){
            int rankCount = result.getOrDefault(rank,0);
            if(rank != Rank.MISS){
                outputView.printWinningResult(rank.getCountOfMatch(), rank.getPrize(),rankCount);
            }
        }
    }
}
