package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.OutputDomain;
import lotto.domain.Statistics;
import lotto.enums.Rank;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printLottoAmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }

    public static void printEachLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println("\n당첨통계\n---");

        List<Rank> rankOrder = Arrays.asList(
                Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST
        );

        for (Rank rank : rankOrder) {
            int count = statistics.getRankCounts().getOrDefault(rank, 0);
            printEachMessage(rank, count);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", statistics.calculateReturnRate());
    }

    private static void printEachMessage(Rank rank, int count) {
        String message = makeMessage(rank, count);
        System.out.println(message);
    }

    private static String makeMessage(Rank rank, int count) {
        return String.format(
                OutputDomain.rankMessages.get(rank),
                count
        );
    }
}
