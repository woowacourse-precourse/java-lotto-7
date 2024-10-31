package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class OutputView {

    private static final String RESULT_HEADER = "당첨 통계\n---";
    private static final String MATCH_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String MATCH_WITH_BONUS_FORMAT = "5개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printSellResult(Lottos lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottos.getSize());
        System.out.println(lottos.toString());
    }

    public void printResult(EnumMap<Rank, Integer> result) {
        System.out.println();
        System.out.println(RESULT_HEADER);

        List<Rank> reversedRanks = new ArrayList<>(result.keySet());
        Collections.sort(reversedRanks, Collections.reverseOrder());

        for (Rank rank : reversedRanks) {
            if (rank == Rank.NONE) {
                continue;
            }

            String message = rank == Rank.SECOND
                    ? String.format(MATCH_WITH_BONUS_FORMAT, rank.getMoney(), result.get(rank))
                    : String.format(MATCH_FORMAT, rank.getMatchCount(), rank.getMoney(), result.get(rank));

            System.out.println(message);
        }
    }

    public void printReturnRate(float returnRate) {
        System.out.println(String.format(RETURN_RATE_FORMAT, returnRate));
    }
}
