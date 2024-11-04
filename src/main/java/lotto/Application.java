package lotto;

import lotto.controller.LottoGameController;
import lotto.view.LottoGameView;

public class Application {
    public static void main(String[] args) {
        LottoGameView lottoGameView = new LottoGameView();
        LottoGameController lottoGameController = new LottoGameController(lottoGameView);

        lottoGameController.playGame();
    }
}
