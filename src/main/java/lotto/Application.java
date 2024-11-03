package lotto;

import lotto.view.Input;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();

        LottoGame lottoGame = new LottoGame(input);
        lottoGame.run();
    }
}
