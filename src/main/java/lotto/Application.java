package lotto;

import lotto.controller.LottoController;
import lotto.service.CalculateService;
import lotto.service.LottoNumberService;
import lotto.service.LottoServiceFacade;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        LottoNumberService lottoNumberService = new LottoNumberService();
        CalculateService calculateService = new CalculateService();
        LottoServiceFacade lottoServiceFacade = new LottoServiceFacade(lottoNumberService, calculateService);

        LottoController controller = new LottoController(inputView, outputView, lottoServiceFacade);
        controller.run();
    }
}
