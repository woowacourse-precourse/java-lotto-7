package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.MatchingResult;

public class OutputView {
    private static final String PURCHASED_LOTTO_INFO_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String STATS_INFO_TITLE = "\n당첨 통계\n---\n";

    public void outputPurchasedLottoInfo(List<Lotto> lottos){
        System.out.printf(PURCHASED_LOTTO_INFO_MESSAGE, lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void outputStatistics(MatchingResult matchingResult){
        System.out.printf(STATS_INFO_TITLE);
        System.out.print(matchingResult.toString());
    }
}
