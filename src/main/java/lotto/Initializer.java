package lotto;

import lotto.controller.Controller;
import lotto.model.LottoMachine;

public final class Initializer {
    private Initializer() {
    }

    public static Controller controller(LottoMachine lottoMachine) {
        return new Controller(lottoMachine);
    }

    public static LottoMachine lottoMachine() {
        return new LottoMachine();
    }
}
