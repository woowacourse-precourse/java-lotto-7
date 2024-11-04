package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoServiceImpl();
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView);

        try {
            lottoController.run();
        } catch (IllegalStateException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
