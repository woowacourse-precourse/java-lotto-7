package lotto.io;

import java.util.List;
import java.util.Map;

import lotto.lotto.LottoAmount;
import lotto.lotto.Lottos;
import lotto.lotto.Rank;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String NEW_LINE = "\n";
    private static final String RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원) - %d개%n";

    @Override
    public void printLotto(Lottos lottos, LottoAmount lottoAmount) {
        int purchaseLottoCount = lottoAmount.getPurchaseLottoCount();
        System.out.println(NEW_LINE + purchaseLottoCount + "개를 구매했습니다.");

        List<List<Integer>> lottoValues = lottos.getLottoValues();
        for (List<Integer> lottoValue : lottoValues) {
            System.out.println(lottoValue);
        }
    }

    @Override
    public void printResult(Map<Rank, Integer> rankSummary, double profitRate) {
        System.out.println(NEW_LINE + "당첨 통계");
        System.out.println("---");
        rankSummary.forEach(this::printRankResult);
        System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
    }

    private void printRankResult(Rank rank, Integer count) {
        if (rank == Rank.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n", rank.getMatchingCount(), rank.getAmount(), count);
            return;
        }
        System.out.printf(RESULT_MESSAGE_FORMAT, rank.getMatchingCount(), rank.getAmount(), count);
    }
}
