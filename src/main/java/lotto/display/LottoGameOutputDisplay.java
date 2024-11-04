package lotto.display;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.LottoRank;

public class LottoGameOutputDisplay {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public void printGuideMessage(String msg) {
        System.out.println(msg);
    }

    public void printGuideMessageWithNewline(String msg) {
        System.out.println();
        System.out.println(msg);
    }

    public void printErrorMessage(Exception e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }

    public void printPurchaseBreakdown(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i).toString());
            sb.append(", ");
        }
        sb.append(numbers.getLast());
        sb.append("]");

        System.out.println(sb);
    }

    public void printWinStatistics(Map<LottoRank, Integer> rankMap, double rateOfResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankBreakdown(rankMap);
        printRateOfResult(rateOfResult);
    }

    private void printRankBreakdown(Map<LottoRank, Integer> winningCntPerRank) {
        List<LottoRank> printLottoRanks = List.of(
                LottoRank.GRADE_5TH,
                LottoRank.GRADE_4TH,
                LottoRank.GRADE_3TH,
                LottoRank.GRADE_2TH,
                LottoRank.GRADE_1TH
        );

        for (LottoRank lottoRank : printLottoRanks) {
            System.out.printf("%s (%,d%s) - %d개\n",
                    lottoRank.getWinCondition(),
                    lottoRank.getPrizeMoney(), LottoRank.UNIT,
                    winningCntPerRank.get(lottoRank)
            );
        }
    }

    private void printRateOfResult(double rateOfResult) {
        // 둘째자리에서 반올림하여 출력
        double result = Math.round(rateOfResult * 100) / 100.0;
        System.out.printf("총 수익률은 %,.1f%%입니다.", result);
    }
}
