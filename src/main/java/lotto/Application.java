package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        lottoController.run();

        Console.close();
    }
}
