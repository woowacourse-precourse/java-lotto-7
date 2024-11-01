package lotto.View;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankResult;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_PURCHASE_COUNT="개를 구매했습니다.";
    private static final String PRINT_WINNING_STATISTICS="당첨 통계";
    private static final String PRINT_SEPARATE_SENTENCE="---";
    private static final String PRINT_WINNING_STATISTICS_SEPARATE=" - ";
    private static final String PRINT_WINNING_STATISTICS_UNIT="개";
    private static final String PRINT_PROFIT="총 수익률은 ";
    private static final String PRINT_PROFIT_UNIT="%입니다.";

    public static void print_purchase_count(int purchase_count) {
        System.out.println(purchase_count+PRINT_PURCHASE_COUNT);
    }
    public static void print_lotto_list(List<Lotto> lottoList) {
        for(int i=0;i<lottoList.size();i++) {
            System.out.println(lottoList.get(i).getNumbers());
        }
        System.out.println();
    }
    public static void print_winning_statistics(RankResult rankResult) {
        System.out.println(PRINT_WINNING_STATISTICS);
        System.out.println(PRINT_SEPARATE_SENTENCE);
        Map<Rank,Integer> winning_statistics=rankResult.getRank_Count();
        for (Rank rank : Rank.values()) {
            int count = winning_statistics.getOrDefault(rank, 0);
            System.out.println(rank.getMessage() + PRINT_WINNING_STATISTICS_SEPARATE + count + PRINT_WINNING_STATISTICS_UNIT);
        }
    }
    public static void print_profit_statistics(double profit_statistics) {
        System.out.println(PRINT_PROFIT+profit_statistics+PRINT_PROFIT_UNIT);
    }
}
