package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.service.ProfitCalculatorService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        final LottoService lottoService = new LottoService();
        final LottoResultService lottoResultService = new LottoResultService();
        final ProfitCalculatorService profitCalculatorService = new ProfitCalculatorService();

        final LottoController lottoController = new LottoController(inputView, outputView, lottoService, lottoResultService, profitCalculatorService);
        lottoController.start();
    }
}
