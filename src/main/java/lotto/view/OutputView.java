package lotto.view;

import lotto.domain.PurchasedLottos;
import lotto.domain.constant.Ranking;

import java.util.EnumMap;

public class OutputView {

    public static final String QUANTITY_OUTPUT_MESSAGE = "%n%d개를 구매했습니다.%n";
    public static final String STATISTIC_OUTPUT_MESSAGE = """
            
            당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            총 수익률은 %,.1f%%입니다.
            """;

    public void printError(String error) {
        System.out.println(error);
    }

    public void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        System.out.printf(QUANTITY_OUTPUT_MESSAGE, purchasedLottos.getQuantity());

        purchasedLottos.getLottos().forEach(lotto ->
                System.out.println(lotto.getNumbers()));
    }

    public void printDrawResult(EnumMap<Ranking, Integer> drawResult, double earningRate) {
        System.out.printf(STATISTIC_OUTPUT_MESSAGE,
                drawResult.get(Ranking.FIFTH),
                drawResult.get(Ranking.FOURTH),
                drawResult.get(Ranking.THIRD),
                drawResult.get(Ranking.SECOND),
                drawResult.get(Ranking.FIRST),
                earningRate
        );
    }
}
