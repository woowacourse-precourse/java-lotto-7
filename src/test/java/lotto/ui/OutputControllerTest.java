package lotto.ui;

import java.util.List;
import lotto.Lotto;
import lotto.LottoContainer;
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
                List.of(new Lotto(List.of(1,2,3,4,5,6)), new Lotto(List.of(2,3,4,5,6,7))));

        outputController.printAllLotteries(lottoContainer);

        Assertions.assertThat(printResult.toString())
                .isEqualTo("2개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[2, 3, 4, 5, 6, 7]\n");
    }
}