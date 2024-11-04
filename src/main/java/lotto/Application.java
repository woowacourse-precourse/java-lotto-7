package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame(new InputView());
        game.play();
    }
}
