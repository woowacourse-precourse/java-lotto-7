package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        LottoController controller = new LottoController(game);
    }
}
