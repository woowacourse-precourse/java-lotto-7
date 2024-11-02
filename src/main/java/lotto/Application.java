package lotto;

import lotto.controller.LottoController;
import lotto.service.BasicLottoService;
import lotto.service.LottoService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int lottoPrice = 1000;
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        LottoService lottoService = new BasicLottoService();

        LottoController controller = new LottoController(lottoPrice, inputView, outputView, lottoService);

        controller.run();
    }
}
