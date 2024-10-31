package lotto;

import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoIssuer;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningResultCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView);

        LottoIssuer lottoIssuer = new LottoIssuer(new LottoGenerator(new LottoNumberGenerator()));
        WinningResultCalculator winningResultCalculator = new WinningResultCalculator();

        LottoController lottoController = new LottoController(lottoIssuer, winningResultCalculator, inputController, outputView);

        lottoController.run();
    }
}
