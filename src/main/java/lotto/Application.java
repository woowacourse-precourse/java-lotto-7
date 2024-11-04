package lotto;

import lotto.config.LottoGameMaker;
import lotto.controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        LottoGameMaker gameMaker = new LottoGameMaker();
        LottoGame lottoGame = gameMaker.makeLottoGame();
        lottoGame.start();
    }
}
