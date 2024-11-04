package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoMachine;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(
                new RandomNumberGenerator());

        LottoGame lottoGame = new LottoGame(new InputHandler(), new OutputHandler(), lottoMachine);
        lottoGame.start();
    }
}
