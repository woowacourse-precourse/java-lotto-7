package lotto;

import lotto.game.LoopForException;
import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        new LoopForException().untilStart();
    }
}