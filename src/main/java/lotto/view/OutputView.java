package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import lotto.Lotto;
import lotto.enums.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printPurchaseMessage(final int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoTickets(final List<Lotto> lottoTickets) {
        lottoTickets.forEach(lotto -> printLottoNumbers(lotto.getNumbers()));
        System.out.println();
    }

    public static void printLottoNumbers(final List<Integer> numbers) {
        final List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.println(sortedNumbers);
    }

    public static void printStatistics(final Map<Rank, Integer> statistics) {
        System.out.println("당첨 통계\n---");

        final List<Rank> sortedRanks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : sortedRanks) {
            final int count = statistics.getOrDefault(rank, 0);
            if (!rank.getDisplayText().isEmpty()) {
                System.out.printf("%s - %d개\n", rank.getDisplayText(), count);
            }
        }
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield);
    }
}
