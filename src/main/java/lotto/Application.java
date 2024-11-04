package lotto;

import lotto.controller.LottoGameController;
import lotto.model.domain.LottoMachine;
import lotto.model.generator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());
        LottoGameController lottoGameController = new LottoGameController(lottoMachine);

        lottoGameController.run();
    }
}
