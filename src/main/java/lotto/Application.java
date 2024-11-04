package lotto;

import lotto.view.Input;
import lotto.view.Output;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        LottoGame lottoGame = new LottoGame(input, output);
        lottoGame.play();
    }
}
