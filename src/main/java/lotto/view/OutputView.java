package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.Calculator;
import lotto.domain.LotteryMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoResultChecker;
import lotto.domain.Money;
import lotto.domain.Rank;

public class OutputView {

    public static void printLottoQuantity(Money money){
        System.out.printf("%d개를 구매했습니다.\n", money.getLottoQuantity());
    }

    public static void printPurchaseLotto(LotteryMachine lotteryMachine, Money money) {
        List<Lotto> lottoByPayment = lotteryMachine.createLottoByPayment(money);
        List<List<Integer>> purchaseLotto = lottoByPayment.stream()
                .map(Lotto::getNumbers).toList();
        for(List<Integer> lotto : purchaseLotto){
            Collections.sort(lotto);
            System.out.println(lotto);
        }
    }

    public static void printLottoResult(LottoResultChecker lottoResultChecker) {
        Map<Rank, Integer> rankCount = lottoResultChecker.getRankCount();
        List<Rank> reverseRank = Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .toList();

        for (Rank rank : reverseRank) {
            Integer matchCount = rankCount.get(rank);
            if (rank.equals(Rank.NONE)) continue;
            System.out.printf("%s - %d개\n", rank.getMessage(), matchCount);
        }
    }

    public static void printLottoProfit(double profit){
        String profitFormat = String.format("%.1f",profit);
        System.out.printf("총 수익률은 %s%% 입니다.",profitFormat);
    }

}
