package lotto;

import lotto.contoller.LottoController;
import lotto.service.ProfitCalculatorService;
import lotto.service.WinningStatisticsService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(
                WinningStatisticsService.getInstance(),
                ProfitCalculatorService.getInstance());
        lottoController.start();
    }
}
