package lotto.view;
import lotto.dto.LottoStatisticDTO;
import lotto.model.Lotto;
import java.util.List;

public class OutputView implements OutputViewer {
    public void printLottoInitSummary(LottoStatisticDTO lottoStatistic, List<Lotto> randomLotteries) {
        printPurchasedLottoNumber(lottoStatistic);
        printRandomLotteries(randomLotteries);
    }

    public void printLottoResult(LottoStatisticDTO lottoStatisticDTO) {
        System.out.println("당첨 통계\n---");
        printLotteries(lottoStatisticDTO);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatisticDTO.yield());
    }

    private void printLotteries(LottoStatisticDTO lottoStatisticDTO) {
        lottoStatisticDTO.statistics().forEach((key, value) -> System.out.printf("%s - %d개%n", key, value));
    }

    private void printPurchasedLottoNumber(LottoStatisticDTO lottoStatistic) {
        System.out.println(lottoStatistic.quantity() + "개를 구매했습니다.");
    }

    private void printRandomLotteries(List<Lotto> randomLotteries) {
        randomLotteries.forEach(lotto -> System.out.println(lotto.numbers()));
    }
}
