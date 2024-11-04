package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {}

    public static void printPurchaseResult(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTickets().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getTickets()) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public static void printStatistics(LottoResult lottoResult, int purchaseAmount) {
        System.out.println("\n당첨 통계\n---");
        Map<Rank, Integer> rankCounts = lottoResult.getRankCounts();

        System.out.println("3개 일치 (5,000원) - " + rankCounts.get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCounts.get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCounts.get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCounts.get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCounts.get(Rank.FIRST) + "개");

        double earningRate = ((double) lottoResult.getTotalWinningAmount() / purchaseAmount) * 100;
        BigDecimal bigDecimal = BigDecimal.valueOf(earningRate).setScale(1, RoundingMode.HALF_UP);
        System.out.println("총 수익률은 " + bigDecimal + "%입니다.");
    }
}
