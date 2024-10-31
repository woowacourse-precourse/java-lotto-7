package lotto;

import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.provider.RandomUniqueNumbersProvider;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new InputHandler(), new OutputHandler(), new RandomUniqueNumbersProvider());
        lottoGame.run();
    }
}
