package lotto.view;

import lotto.domain.constant.Ranking;
import lotto.dto.response.LottosResponse;

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
            """;

    public void printPurchasedLottos(LottosResponse response) {
        addLottoQuantityToBuffer(response);
        addLottosToBuffer(response);
        bufferClear();
    }

    public void printError(String error) {
        System.out.println(error);
    }

    private void addLottoQuantityToBuffer(LottosResponse response) {
        BUFFER.append(NEW_LINE)
                .append(response.quantity())
                .append(QUANTITY_OUTPUT_MESSAGE)
                .append(NEW_LINE);
    }

    private void addLottosToBuffer(LottosResponse response) {
        response.lottos().forEach(lotto ->
                BUFFER.append(lotto.lotto())
                        .append(NEW_LINE));
    }

    private void bufferClear() {
        System.out.print(BUFFER);
        BUFFER.setLength(0);
    }

    public void printDrawResult(EnumMap<Ranking, Integer> drawResult) {
        System.out.printf(NEW_LINE+ STATISTIC_OUTPUT_MESSAGE,
                drawResult.get(Ranking.FIFTH),
                drawResult.get(Ranking.FOURTH),
                drawResult.get(Ranking.THIRD),
                drawResult.get(Ranking.SECOND),
                drawResult.get(Ranking.FIRST)
        );
    }
}
