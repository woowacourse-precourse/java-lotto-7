package lotto.view;
import lotto.dto.LottoStatisticDTO;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;
import java.util.List;

public class OutputView {
    public static void printLottoInitSummary(LottoStatisticDTO lottoStatistic, List<Lotto> randomLotteries) {
        printPurchasedLottoNumber(lottoStatistic);
        printRandomLotteries(randomLotteries);
    }

    public static void printLottoResult(LottoStatistics lottoStatistic) {
        LottoStatisticDTO lottoStatisticDTO = lottoStatistic.toDTO();
        System.out.println("당첨 통계\n---");
        lottoStatisticDTO.statistics().forEach((key, value) -> System.out.printf("%s - %d개%n", key, value));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatisticDTO.yield());
    }

    private static void printPurchasedLottoNumber(LottoStatisticDTO lottoStatistic) {
        System.out.println(lottoStatistic.quantity() + "개를 구매했습니다.");
    }

    private static void printRandomLotteries(List<Lotto> randomLotteries) {
        for (Lotto lotto : randomLotteries) {
            System.out.println(lotto.getNumbers());
        }
    }
}
