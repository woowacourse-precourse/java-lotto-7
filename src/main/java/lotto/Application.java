package lotto;

import lotto.config.Config;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame(new Config());
        lottoGame.run();
    }
}