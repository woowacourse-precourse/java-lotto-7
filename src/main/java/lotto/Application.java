package lotto;

import lotto.config.factory.LottoGameFactory;
import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = LottoGameFactory.create();
        lottoGame.play();
    }
}
