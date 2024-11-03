package lotto.view;

import java.util.Map;
import lotto.domain.*;
import lotto.service.ResultCalculator;

public class OutputView {
    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }


    public void printWinningDetails(ResultCalculator resultCalculator) {
        System.out.println();
        System.out.println("당첨 통계\n---");

        Map<LottoRank, Integer> results = resultCalculator.getResult();
        results.forEach((rank, count) -> {
            if (rank == LottoRank.NONE) return;;
            String resultMessage = formatPrizeMessage(rank, count);
            System.out.println(resultMessage);
        });

    }

    private String formatPrizeMessage(LottoRank rank, int count) {
        return String.format(rank.getDescription() + " - %d개",
                count);
    }

    public void printYield(double yield) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", yield);
    }
}
