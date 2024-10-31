package lotto;

import lotto.provider.RandomUniqueNumbersProvider;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new RandomUniqueNumbersProvider());
        lottoGame.run();
    }
}
