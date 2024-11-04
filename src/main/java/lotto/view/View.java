package lotto.view;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import lotto.model.*;
import lotto.controller.*;

public class View {
    private View() {
    }

    public static void integrateView() {
        Integer lottoCount = MoneyCount.countTimes(PurchasingInput.getCost());

        MyLottoNum lottoNum = new MyLottoNum();
        lottoNum.makeMyLotto(lottoCount);
        lottoNum.printMyLottoList();

        Set<Integer> WinningNum = WinningLottoInput.getWinningNumbers();
        Integer bonusNum = WinningLottoInput.getBonusNumber(WinningNum);

        List<Integer> matchCounts = MatchCount.calculateMatchCounts(WinningNum, lottoNum.getLottoList());
        List<Integer> bonusCounts = MatchCount.calculateBonusCounts(WinningNum, lottoNum.getLottoList(), bonusNum);

        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }

        for (int i = 0; i < matchCounts.size(); i++) {
            int matchCount = matchCounts.get(i);
            boolean bonusMatch = bonusCounts.get(i) > 0;

            LottoRank rank = LottoRank.getRank(matchCount, bonusMatch);

            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();

        int totalPurchaseAmount = matchCounts.size() * 1000;

        double profitRate = (double) totalPrize / totalPurchaseAmount * 100;

        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (%,d원) - %d개%n", LottoRank.FIFTH.getPrize(), rankCounts.get(LottoRank.FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개%n", LottoRank.FOURTH.getPrize(), rankCounts.get(LottoRank.FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개%n", LottoRank.THIRD.getPrize(), rankCounts.get(LottoRank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", LottoRank.SECOND.getPrize(),
                rankCounts.get(LottoRank.SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개%n", LottoRank.FIRST.getPrize(), rankCounts.get(LottoRank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
