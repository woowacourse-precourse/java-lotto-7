package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputHandler {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨통계\n---\n";

    public void printPurchasedLotto(int count, List<Lotto> lottos) {
        System.out.println("\n" + count + PURCHASE_MESSAGE);
        for (Lotto lotto:lottos) {
            System.out.println(makeLottoNumberStringFormat(lotto));
        }
        System.out.println();
    }

    public void printResult(Map<Rank,Integer> rankCount, double rateOfReturn) {
        System.out.println(RESULT_MESSAGE);
        for (Map.Entry<Rank, Integer> entry : rankCount.entrySet()) {
            Rank rank = entry.getKey();
            System.out.println(resultMessageFormat(rank,entry.getValue()));
        }
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");

    }

    private String makeLottoNumberStringFormat(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private String resultMessageFormat(Rank rank, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchNumbers()).append("개 일치");
        if (rank.getMatchNumbers() == 5 && rank.getIsBonusMatch()) {
            sb.append(", 보너스 불 일치 ");
        }
        sb.append(" (").append(rank.getWinningPrice()).append(") ");
        sb.append(" - ").append(count).append("개");
        return sb.toString();
    }
}
