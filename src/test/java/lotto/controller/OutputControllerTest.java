package lotto.controller;

import lotto.model.Lotto;
import lotto.service.OutputService;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputControllerTest {
    private OutputController outputController;
    private String lastPrintedMessage;

    @BeforeEach
    void setUp() {
        OutputView outputView = new OutputView() {
            @Override
            public void printMessage(String message) {
                lastPrintedMessage = message;
            }
        };

        OutputService outputService = new OutputService() {
            @Override
            public String getLottoCountMessage(int lottoCount) {
                return "8개를 구매했습니다.";
            }

            @Override
            public String getLottosMessage(List<Lotto> lottos) {
                return "[1, 2, 3, 4, 5, 6]\n";
            }

            @Override
            public String getLottoStatisticsMessage(int[] matchCounts) {
                return "3개 일치 (5,000원) - 1개";
            }

            @Override
            public String getYieldMessage(double yield) {
                return "총 수익률은 62.5%입니다.";
            }
        };

        outputController = new OutputController(outputService, outputView);
    }

    @Test
    void displayLottoCount_테스트() {
        outputController.displayLottoCount(8);
        assertEquals("8개를 구매했습니다.", lastPrintedMessage);
    }

    @Test
    void displayLottos_테스트() {
        outputController.displayLottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        assertEquals("[1, 2, 3, 4, 5, 6]\n", lastPrintedMessage);
    }

    @Test
    void displayWinningStatistics_테스트() {
        outputController.displayWinningStatistics(new int[]{1, 0, 0, 0, 0});
        assertEquals("3개 일치 (5,000원) - 1개", lastPrintedMessage);
    }

    @Test
    void displayYield_테스트() {
        outputController.displayYield(62.5);
        assertEquals("총 수익률은 62.5%입니다.", lastPrintedMessage);
    }
}
