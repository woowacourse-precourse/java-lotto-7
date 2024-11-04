package lotto.view.output;

import java.util.*;
import java.util.TreeMap;
import lotto.domain.*;
import lotto.service.ResultCalculator;

public class OutputView implements Output {

    @Override
    public void printLottoCount(int lottoCount) {
        System.out.printf("%n%d개를 구매했습니다.%n", lottoCount);
    }

    @Override
    public void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);

        System.out.println();
    }

    @Override
    public void printWinningDetails(ResultCalculator resultCalculator) {
        System.out.println("\n당첨 통계\n---");

        Map<LottoRank, Integer> results = new TreeMap<>(resultCalculator.getResult());

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.NONE) {
                continue;
            }
            int count = results.getOrDefault(rank, 0);
            System.out.println(formatPrizeMessage(rank, count));
        }
    }

    private String formatPrizeMessage(LottoRank rank, int count) {
        return String.format(rank.getDescription() + " - %d개", count);
    }

    @Override
    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    @Override
    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
