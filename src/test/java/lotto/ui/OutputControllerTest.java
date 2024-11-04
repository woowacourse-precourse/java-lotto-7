package lotto.ui;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.LottoContainer;
import lotto.LottoNum;
import lotto.Results;
import lotto.common.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OutputControllerTest {

    private final StringBuilder printResult = new StringBuilder();
    private final OutputUi outputUi = new OutputUi() {
        @Override
        public void print(final String message) {
            printResult.append(message);
        }

        @Override
        public void printWithLineBreak(final String message) {
            printResult.append(message + "\n");
        }
    };

    @Test
    void 발행_목록_출력_테스트() {
        final OutputController outputController = new OutputController(outputUi);
        final LottoContainer lottoContainer = new LottoContainer(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6).stream()
                                .map(LottoNum::new).collect(Collectors.toList())),
                        new Lotto(List.of(2, 3, 4, 5, 6, 7).stream()
                                .map(LottoNum::new).collect(Collectors.toList()))
                )
        );

        outputController.printAllLotteries(lottoContainer);

        Assertions.assertThat(printResult.toString())
                .isEqualTo("2개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[2, 3, 4, 5, 6, 7]\n");
    }

    @Test
    void 통계_출력_테스트() {
        final OutputController outputController = new OutputController(outputUi);

        outputController.printStatisticResults(new Results(List.of(LottoResult.THIRD, LottoResult.SECOND)));
        Assertions.assertThat(printResult.toString())
                .isEqualTo("당첨 통계\n"
                        + "---\n"
                        + "3개 일치 (5,000원) - 0개\n"
                        + "4개 일치 (50,000원) - 0개\n"
                        + "5개 일치 (1,500,000원) - 1개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                        + "6개 일치 (2,000,000,000원) - 0개\n");
    }

    @Test
    void 반올림_테스트() {
        final BigDecimal bigDecimal = new BigDecimal("150.252");

        Assertions.assertThat(bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP))
                .isEqualTo(new BigDecimal("150.3"));
    }
}