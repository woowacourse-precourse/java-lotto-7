package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.model.LottoMachine;

public class LottoController {
    private final LottoBuyer lottoBuyer;

    public LottoController() {
        LottoMachine lottoMachine = new LottoMachine();
        this.lottoBuyer = new LottoBuyer(lottoMachine);
    }
}
