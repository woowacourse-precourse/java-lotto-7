package lotto.view;

import static lotto.model.ProfitCalculator.Three;
import static lotto.model.ProfitCalculator.Five;
import static lotto.model.ProfitCalculator.FiveBonus;
import static lotto.model.ProfitCalculator.Four;
import static lotto.model.ProfitCalculator.Six;
import static lotto.utils.LottoConfig.FIVE_MATCHES_PRIZE;
import static lotto.utils.LottoConfig.FIVE_MATCHES_WITH_BONUS_PRIZE;
import static lotto.utils.LottoConfig.FOUR_MATCHES_PRIZE;
import static lotto.utils.LottoConfig.SIX_MATCHES_PRIZE;
import static lotto.utils.LottoConfig.THREE_MATCHES_PRIZE;


import java.util.List;
import java.util.Map;
import lotto.model.Lotto;

public class OutputView {
    private final String NUMBER_OF_PURCHASE = "\n%d개를 구매했습니다.";
    private final String STATISTICS_HEADER = "\n당첨 통계\n---";
    private final String THREE_MATCHES = "3개 일치 (%,d원) - %d개";
    private final String FOUR_MATCHES = "4개 일치 (%,d원) - %d개";
    private final String FIVE_MATCHES = "5개 일치 (%,d원) - %d개";
    private final String FIVE_MATCHES_WITH_BONUS = "5개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final String SIX_MATCHES = "6개 일치 (%,d원) - %d개";
    private final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.";


    public void printNumberOfPurchase(int purchase, List<Lotto> lottos) {
        System.out.println(String.format(NUMBER_OF_PURCHASE, purchase));
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printStatistics(Map<Integer, Integer> matches, float profitRate) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(String.format(THREE_MATCHES, THREE_MATCHES_PRIZE.getValue(), matches.get(Three)));
        System.out.println(String.format(FOUR_MATCHES, FOUR_MATCHES_PRIZE.getValue(), matches.get(Four)));
        System.out.println(String.format(FIVE_MATCHES, FIVE_MATCHES_PRIZE.getValue(), matches.get(Five)));
        System.out.println(String.format(FIVE_MATCHES_WITH_BONUS, FIVE_MATCHES_WITH_BONUS_PRIZE.getValue(), matches.get(FiveBonus)));
        System.out.println(String.format(SIX_MATCHES, SIX_MATCHES_PRIZE.getValue(), matches.get(Six)));
        System.out.println(String.format(TOTAL_PROFIT, profitRate));
    }
}
