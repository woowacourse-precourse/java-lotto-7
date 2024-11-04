package lotto;

import lotto.controller.LottoController;
import lotto.service.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();

        final LottoService lottoService = new LottoService();
        final LottoMachineService lottoMachineService = new LottoMachineService();
        final LottoBundleService bundleService = new LottoBundleService();
        final LottoResultService lottoResultService = new LottoResultService();
        final ProfitCalculatorService profitCalculatorService = new ProfitCalculatorService();

        final LottoController lottoController = new LottoController(inputView, outputView, lottoService, lottoMachineService, bundleService, lottoResultService, profitCalculatorService);
        lottoController.start();
    }
}
