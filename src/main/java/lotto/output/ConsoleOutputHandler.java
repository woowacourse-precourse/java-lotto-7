package lotto.output;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class ConsoleOutputHandler implements OutputHandler {

    @Override
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(getSortedNumbers(lotto)));
    }

    @Override
    public void printResult(LottoResult result) {
        System.out.println("당첨 통계\n---");

        List<Rank> ranks = Rank.getDescendingRanks();
        Map<Rank, Integer> rankCount = result.getRankCount();

        for (Rank rank : ranks) {
            int count = rankCount.get(rank);
            System.out.printf("%s - %d개%n", rank.getFormattedResult(), count);
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getYield());
    }

    private List<Integer> getSortedNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .toList();
    }
}
