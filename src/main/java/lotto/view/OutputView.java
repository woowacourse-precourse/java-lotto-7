package lotto.view;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.LottoPaper;
import lotto.dto.RankResult;

public class OutputView {

    private static final List<Rank> PRINT_RANKS = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    private static final NumberFormat currencyFormat = NumberFormat.getNumberInstance();
    private static final String SECOND_RANK_MESSAGE_PATTERN = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String DEFAULT_RANK_MESSAGE_PATTERN = "%d개 일치 (%s원) - %d개\n";

    public static void renderPaper(LottoPaper paper) {
        printPurchaseCount(paper);
        printLottos(paper);
        printEmptySpace();
    }

    private static void printPurchaseCount(LottoPaper paper) {
        System.out.printf("%d개를 구매했습니다\n", paper.count());
    }

    private static void printLottos(LottoPaper paper) {
        for (Lotto lotto : paper.getLottos()) {
            List<Integer> lottoNumbers = lotto.toIntList();
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public static void renderStatistics(LottoPaper lottoPaper, RankResult ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printRanks(ranks);
    }

    private static void printRanks(RankResult ranks) {
        for (Rank rank : PRINT_RANKS) {
            System.out.printf(findPattern(rank), rank.count(), currencyFormat.format(rank.price()), ranks.count(rank));
        }
    }

    private static String findPattern(Rank rank) {
        if (Rank.SECOND.equals(rank)) {
            return SECOND_RANK_MESSAGE_PATTERN;
        }
        return DEFAULT_RANK_MESSAGE_PATTERN;
    }

    private static void printEmptySpace() {
        System.out.println();
    }
}
