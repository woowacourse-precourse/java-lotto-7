package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;

public class LottoView {

    RankMessageGenerator rankMessageGenerator = new RankMessageGenerator();

    public void showWinningResult(Map<LottoRank, Integer> ranks) {
        List<LottoRank> lottoRanks = LottoRank.getRanksOrderByReward();
        for (LottoRank lottoRank : lottoRanks) {
            String message = rankMessageGenerator.getMessage(lottoRank, ranks);
            System.out.println(message);
        }
    }

}
