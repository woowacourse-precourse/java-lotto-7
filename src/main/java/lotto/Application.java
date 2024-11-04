package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        LottoController controller = new LottoController(game);
    }
}
