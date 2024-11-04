package lotto;

import lotto.controller.LottoGame;
import lotto.domain.LottoMachine;
import lotto.domain.common.RealRandom;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        RealRandom random = new RealRandom();
        LottoGame lottoGame = new LottoGame(lottoMachine, random);

        lottoGame.start();
    }
}
