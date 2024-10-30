package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoGeneratorService;
import lotto.service.LottoService;
import lotto.service.ProfitCalculatorService;
import lotto.service.PurchaseService;
import lotto.service.StatisticsService;
import lotto.service.WinningLottoService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class AppConfig {

    public LottoController lottoController() {
        return new LottoController(inputView(), outputView(), lottoService());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private LottoService lottoService() {
        return new LottoService(purchaseService(), lottoGeneratorService(), statisticsService(), profitCalculatorService(), winningLottoService());
    }

    private PurchaseService purchaseService() {
        return new PurchaseService();
    }

    private LottoGeneratorService lottoGeneratorService() {
        return new LottoGeneratorService();
    }

    private StatisticsService statisticsService() {
        return new StatisticsService();
    }

    private ProfitCalculatorService profitCalculatorService() {
        return new ProfitCalculatorService();
    }

    private WinningLottoService winningLottoService() {
        return new WinningLottoService();
    }

}
