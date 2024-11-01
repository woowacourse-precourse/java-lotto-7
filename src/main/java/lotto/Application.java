package lotto;

import lotto.controller.InputHandler;
import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputHandler inputController = new InputHandler(inputView);

        LottoIssuer lottoIssuer = new LottoIssuer(new LottoGenerator(new LottoNumberGenerator()));

        LottoController lottoController = new LottoController(lottoIssuer, inputController, outputView);

        lottoController.run();
    }
}
