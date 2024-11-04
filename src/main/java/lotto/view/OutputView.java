package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.LottoService.*;

import java.util.List;
import java.util.Map;

import static lotto.model.LottoService.BONUS_KEY;


public class OutputView {
    private final LottoService lottoService;

    public OutputView(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public void printResult(Map<Integer, Integer> result, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        result.forEach((key, value) -> {
            if (key == BONUS_KEY) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", lottoService.getPrizeAmount(BONUS_KEY), value);
            }
            if (key != BONUS_KEY) {
                System.out.printf("%d개 일치 (%,d원) - %d개\n", key, lottoService.getPrizeAmount(key), value);
            }
        });

        System.out.printf("총 수익률은 %.1f%%입니다.\n", Math.round(rateOfReturn * 10) / 10.0);
    }


}
