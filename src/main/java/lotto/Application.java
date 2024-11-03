package lotto;

import lotto.io.ConsoleInputHandler;
import lotto.io.ConsoleOutputHandler;
import lotto.lotto.LottoGame;
import lotto.lotto.LottoNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new ConsoleInputHandler(), new ConsoleOutputHandler(), new LottoNumberGenerator());
        lottoGame.run();
    }
}
