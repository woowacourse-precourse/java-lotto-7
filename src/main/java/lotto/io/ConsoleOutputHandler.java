package lotto.io;

import java.util.List;
import java.util.Map;

import lotto.lotto.LottoAmount;
import lotto.lotto.Lottos;
import lotto.lotto.Rank;

public class ConsoleOutputHandler implements OutputHandler {

    private static final String NEW_LINE = "\n";
    private static final String RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원) - %d개";

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
        rankSummary.forEach((rank, count) ->
                System.out.println(String.format(RESULT_MESSAGE_FORMAT, rank.getMatchingCount(), rank.getAmount(), count)));
        System.out.println(String.format("총 수익률은 %.2f입니다.", profitRate));
    }
}
