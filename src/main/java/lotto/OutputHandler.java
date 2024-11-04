package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
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
            if (rank.getMatchNumbers() != 0){
                System.out.println(resultMessageFormat(rank,entry.getValue()));
            }
        }
        BigDecimal roundedResult = new BigDecimal(rateOfReturn).setScale(1, RoundingMode.HALF_UP);
        System.out.println("총 수익률은 " + roundedResult + "%입니다.");
    }

    private String makeLottoNumberStringFormat(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
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
        NumberFormat numberFormat = NumberFormat.getInstance();
        sb.append(rank.getMatchNumbers()).append("개 일치");
        if (rank.getMatchNumbers() == 5 && rank.getIsBonusMatch()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (").append(numberFormat.format(rank.getWinningPrice())).append("원)");
        sb.append(" - ").append(count).append("개");
        return sb.toString();
    }
}
