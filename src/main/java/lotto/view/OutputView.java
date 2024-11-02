package lotto.view;

import lotto.domain.PurchasedLottos;
import lotto.domain.constant.Ranking;

import java.util.EnumMap;

public class OutputView {

    private static final StringBuilder BUFFER = new StringBuilder();
    private static final String NEW_LINE = "\n";
    public static final String QUANTITY_OUTPUT_MESSAGE = "개를 구매했습니다.";
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

    public void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        addLottoQuantityToBuffer(purchasedLottos);
        addLottosToBuffer(purchasedLottos);
        bufferClear();
    }

    public void printError(String error) {
        System.out.println(error);
    }

    private void addLottoQuantityToBuffer(PurchasedLottos purchasedLottos) {
        BUFFER.append(NEW_LINE)
                .append(purchasedLottos.getLottos().size())
                .append(QUANTITY_OUTPUT_MESSAGE)
                .append(NEW_LINE);
    }

    private void addLottosToBuffer(PurchasedLottos purchasedLottos) {
        purchasedLottos.getLottos().forEach(lotto ->
                BUFFER.append(lotto.getNumbers())
                        .append(NEW_LINE));
    }

    private void bufferClear() {
        System.out.print(BUFFER);
        BUFFER.setLength(0);
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
