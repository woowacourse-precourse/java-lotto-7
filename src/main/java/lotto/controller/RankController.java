package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.RankService;
import lotto.view.OutputRanking;
import java.util.List;

public class RankController {

    private final OutputRanking outputRanking;

    public RankController() {
        this.outputRanking = new OutputRanking();
    }

    public RankService rankingStatistics(List<Lotto> lottos, List<Integer> winnings, int bonus) {
        RankService ranking = new RankService();
        ranking.checkRank(lottos, winnings, bonus);
        outputRanking.rankingOutput(ranking);
        return ranking;
    }

}
