package lotto;

import lotto.service.Lotto;
import lotto.service.Purchase;
import lotto.view.input.Input;
import lotto.view.output.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        game.gameStart();

    }
}
