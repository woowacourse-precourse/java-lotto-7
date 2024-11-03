package lotto;

import lotto.controller.LottoController;
import lotto.model.Game;
import lotto.model.RandomLottoGenerator;
import lotto.model.purchase.LottoStore;
import lotto.utils.Constants;
import lotto.view.ConsoleView;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Game game = new Game(new LottoStore(Constants.LOTTO_PRICE, new RandomLottoGenerator()));
        LottoController lottoController = new LottoController(view, game);
        lottoController.run();
    }
}
