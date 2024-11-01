package lotto.view;

import lotto.dto.LottoStatisticDTO;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;

import java.util.List;

public class OutputView {
    public static void displayLottoCount(LottoStatisticDTO lottoStatistic) {
        System.out.println(lottoStatistic.quantity() + "개를 구매했습니다.");
    }

    public static void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(LottoStatistics lottoStatistic) {
        LottoStatisticDTO lottoStatisticDTO = lottoStatistic.toDTO();
        System.out.println("당첨 통계\n---");
        lottoStatisticDTO.statistics().forEach((key, value) -> System.out.printf("%s - %d개%n", key, value));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", lottoStatisticDTO.yield());
    }
}
