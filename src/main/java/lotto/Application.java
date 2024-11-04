package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoController controller = new LottoController(game, inputView, outputView);

        controller.run();
    }
}
